package com.beatit.controllers;

import java.util.List;

import com.beatit.datatypes.DTChallenge;
import com.beatit.datatypes.DTDateTime;
import com.beatit.entities.Challenge;
import com.beatit.interfaces.IChallengeController;

public class ChallengeController implements IChallengeController {

	@Override
	public List<Challenge> listarDesafiosDisponibles(DTDateTime date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Challenge> listarDesafiosIniciados(DTDateTime date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void iniciarDesafio(Challenge c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelarDeafio(Challenge c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void completarDesafio(Challenge c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DTChallenge verDesafioFinalizado(Challenge c) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	

}
