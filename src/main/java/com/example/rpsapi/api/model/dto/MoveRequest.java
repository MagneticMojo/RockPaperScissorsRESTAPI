package com.example.rpsapi.api.model.dto;

import com.example.rpsapi.api.model.entities.Move;

public record MoveRequest(String playerName, Move move) {
}
