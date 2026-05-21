package aircraft;

public enum AircraftMessages {
	BALLOON,
	JETPLANE,
	HELICOPTER;

	public String getMessage(String weather) {
		return switch (this) {
			case BALLOON	-> switch (weather) {
				case "SUN"		-> "Burn baby burn";								// The Trammps - Disco Inferno
				case "RAIN"		-> "It's raining men. Hallelujah";					// The Weather Girls - It's Raining Men
				case "FOG"		-> "I can feel it coming in the air tonight";		// Phil Collins - In The Air Tonight
				case "SNOW"		-> "Let it snow, let it snow, let it snow";			// Dean Martin - Let It Snow!
				default			-> "Lonely, I'm Mr. lonely";						// ? *
			};

			case JETPLANE	-> switch (weather) {
				case "SUN"		-> "This girl is on fire";							// Alicia Keys - Girl On Fire
				case "RAIN"		-> "I'm singing in the rain";						// Gene Kelly - Singin' In The Rain
				case "FOG"		-> "It's gettin' dark, too dark to see";			// Guns N' Roses – Knockin' On Heaven's Door
				case "SNOW"		-> "Come to decide that the things that I tried";	// Red Hot Chili Peppers - Snow (Hey Oh)
				default			-> "Hello darkness my old friend";					// ? **
			};

			case HELICOPTER	-> switch (weather) {
				case "SUN"		-> "Allumez le feu";								// Johnny Hallyday - Allumez Le Feu
				case "RAIN"		-> "Toujours autant de pluie chez moi";				// Orelsan - La pluie
				case "FOG"		-> "Tout est devenu flou";							// Angèle - Flou
				case "SNOW"		-> "Le froid est pour moi le prix de la liberté";	// Anaïs Delva – Libérée, délivrée
				default			-> "J'suis pas tout seul à être tout seul";			// ? ***
			};
		};
	}
}

//? SURPRISE BLINDTEST : find titles and authors!
