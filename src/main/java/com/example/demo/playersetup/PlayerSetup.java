package com.example.demo.playersetup;

import com.example.demo.domain.Headgear;
import com.example.demo.domain.Player;
import com.example.demo.domain.PlayerRepository;
import com.example.demo.domain.Weapon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Creates a player and its equipment based on a {@link GivenPlayer} object.
 */
@Component
@RequiredArgsConstructor
public class PlayerSetup {

	private final PlayerRepository playerRepository;

	public void setUp(GivenPlayer givenPlayer) {
		var player = new Player(givenPlayer.getId(), givenPlayer.getName());
		player.setLevel(givenPlayer.getLevel());

		GivenWeapon givenWeapon = givenPlayer.getWeapon();
		if (givenWeapon != null) {
			var weapon = new Weapon(givenWeapon.getId(), givenWeapon.getType(),
				givenWeapon.getAttackPoints(), givenWeapon.getColor());
			player.setWeapon(weapon);
			givenWeapon.setEntity(weapon);
		}

		GivenHeadgear givenHeadgear = givenPlayer.getHeadgear();
		if (givenHeadgear != null) {
			var headgear = new Headgear(givenHeadgear.getId(), givenHeadgear.getType(),
				givenHeadgear.getDefensePoints(), givenHeadgear.getColor());
			player.setHeadgear(headgear);
			givenHeadgear.setEntity(headgear);
		}

		playerRepository.save(player);
		givenPlayer.setEntity(player);
	}

}
