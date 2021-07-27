package com.logigame.gravity.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logigame.gravity.controller.dto.ConnectRequest;
import com.logigame.gravity.exception.InvalidGameException;
import com.logigame.gravity.exception.InvalidParamException;
import com.logigame.gravity.exception.NotFoundException;
import com.logigame.gravity.model.Game;
import com.logigame.gravity.model.Gameplay;
import com.logigame.gravity.model.Player;
import com.logigame.gravity.service.GameService;

@CrossOrigin
@RestController
@RequestMapping("/api/game")
public class GameController {
	
	Logger logger = LoggerFactory.getLogger(GameController.class);
	
	private final GameService gameService = new GameService();
	private final SimpMessagingTemplate simpMessagingTemplate;
	
	public GameController(SimpMessagingTemplate simpMessagingTemplate) {
		super();
		this.simpMessagingTemplate = simpMessagingTemplate;
	}
	
	@GetMapping("/")
	public ResponseEntity<Void> healthCheck() {
		logger.info("Health Checking success");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/start")
	public ResponseEntity<Game> start(@RequestBody Player player) {
		logger.info("Start game request: {}", player);
		return ResponseEntity.ok(gameService.createGame(player));
	}
	
	@PostMapping("/connect")
	public ResponseEntity<Game> connect(@RequestBody ConnectRequest request) throws InvalidParamException, InvalidGameException {
		logger.info("Connect game request: {}", request);
		return ResponseEntity.ok(gameService.connectToGame(request.getPlayer(), request.getGameId()));
	}
	
	@PostMapping("/connect/random")
	public ResponseEntity<Game> connectToRandomGame(@RequestBody Player player) throws NotFoundException {
		logger.info("Connect to random game request: {}", player);
		return ResponseEntity.ok(gameService.connectToRandomGame(player));
	}
	
	@PostMapping("/gameplay")
	public ResponseEntity<Game> gameplay(@RequestBody Gameplay request) throws InvalidParamException, InvalidGameException {
		logger.info("Gameplay : {}", request);
		Game game = gameService.gamePlay(request);
		simpMessagingTemplate.convertAndSend("topic/game-progress"+game.getGameId(), game);
		return ResponseEntity.ok(game);
	}
}












