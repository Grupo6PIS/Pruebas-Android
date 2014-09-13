package com.beatit.interfaces;

import java.util.List;

import com.beatit.datatypes.DTChallenge;
import com.beatit.datatypes.DTDateTime;
import com.beatit.entities.Challenge;

public interface IChallengeController {
	
	public abstract List<Challenge> listarDesafiosDisponibles(DTDateTime date);
	public abstract List<Challenge> listarDesafiosIniciados(DTDateTime date);
	public abstract void iniciarDesafio(Challenge c);
	public abstract void cancelarDeafio(Challenge c);
	public abstract void completarDesafio(Challenge c);
	public DTChallenge verDesafioFinalizado(Challenge c);
	
}
