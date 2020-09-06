package com.example.demo.app.controller;

import com.example.demo.domain.Headgear;
import com.example.demo.domain.Player;
import com.example.demo.domain.PlayerRepository;
import com.example.demo.domain.Weapon;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PlayerController {

	private final PlayerRepository playerRepository;

	/**
	 * Renders an SVG that shows the current state of the {@link Player} entity.
	 */
	@GetMapping(value = "/player", produces = "image/svg+xml")
	public String getPlayer() {
		Player player = playerRepository.getCurrentPlayer();

		String headgearColor = player.getHeadgear()
			.map(Headgear::getColor)
			.orElse("#000000");

		String weaponColor = player.getWeapon()
			.map(Weapon::getColor)
			.orElse("#000000");

		return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
			"<svg\n" +
			"   xmlns:dc=\"http://purl.org/dc/elements/1.1/\"\n" +
			"   xmlns:cc=\"http://creativecommons.org/ns#\"\n" +
			"   xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n" +
			"   xmlns:svg=\"http://www.w3.org/2000/svg\"\n" +
			"   xmlns=\"http://www.w3.org/2000/svg\"\n" +
			"   xmlns:xlink=\"http://www.w3.org/1999/xlink\"\n" +
			"   xmlns:sodipodi=\"http://sodipodi.sourceforge.net/DTD/sodipodi-0.dtd\"\n" +
			"   xmlns:inkscape=\"http://www.inkscape.org/namespaces/inkscape\"\n" +
			"   sodipodi:docname=\"player.svg\"\n" +
			"   inkscape:version=\"1.0 (4035a4f, 2020-05-01)\"\n" +
			"   id=\"svg8\"\n" +
			"   version=\"1.1\"\n" +
			"   viewBox=\"0 0 210 297\"\n" +
			"   height=\"297mm\"\n" +
			"   width=\"210mm\">\n" +
			"  <defs\n" +
			"     id=\"defs2\">\n" +
			"    <pattern\n" +
			"       patternTransform=\"matrix(0.26458333,0,0,0.26458333,71.993239,44.470571)\"\n" +
			"       id=\"pattern1949\"\n" +
			"       xlink:href=\"#pattern984\"\n" +
			"       inkscape:collect=\"always\" />\n" +
			"    <linearGradient\n" +
			"       id=\"linearGradient94\"\n" +
			"       inkscape:collect=\"always\">\n" +
			"      <stop\n" +
			"         id=\"stop90\"\n" +
			"         offset=\"0\"\n" +
			"         style=\"stop-color:#e6e6e6;stop-opacity:1\" />\n" +
			"      <stop\n" +
			"         id=\"stop92\"\n" +
			"         offset=\"1\"\n" +
			"         style=\"stop-color:#999999;stop-opacity:1\" />\n" +
			"    </linearGradient>\n" +
			"    <linearGradient\n" +
			"       id=\"linearGradient73\"\n" +
			"       inkscape:collect=\"always\">\n" +
			"      <stop\n" +
			"         id=\"stop69\"\n" +
			"         offset=\"0\"\n" +
			"         style=\"stop-color:#b3b3b3;stop-opacity:1\" />\n" +
			"      <stop\n" +
			"         id=\"stop71\"\n" +
			"         offset=\"1\"\n" +
			"         style=\"stop-color:#e6e6e6;stop-opacity:1\" />\n" +
			"    </linearGradient>\n" +
			"    <linearGradient\n" +
			"       gradientTransform=\"rotate(44.110068,229.04855,108.27744)\"\n" +
			"       spreadMethod=\"reflect\"\n" +
			"       gradientUnits=\"userSpaceOnUse\"\n" +
			"       y2=\"161.27576\"\n" +
			"       x2=\"123.37956\"\n" +
			"       y1=\"161.26938\"\n" +
			"       x1=\"120.47306\"\n" +
			"       id=\"linearGradient75\"\n" +
			"       xlink:href=\"#linearGradient73\"\n" +
			"       inkscape:collect=\"always\" />\n" +
			"    <linearGradient\n" +
			"       gradientTransform=\"matrix(-0.83344069,-0.55260893,-0.55260893,0.83344069,283.2073,69.079971)\"\n" +
			"       spreadMethod=\"reflect\"\n" +
			"       gradientUnits=\"userSpaceOnUse\"\n" +
			"       y2=\"90.979774\"\n" +
			"       x2=\"136.68663\"\n" +
			"       y1=\"90.979774\"\n" +
			"       x1=\"128.29739\"\n" +
			"       id=\"linearGradient96\"\n" +
			"       xlink:href=\"#linearGradient94\"\n" +
			"       inkscape:collect=\"always\" />\n" +
			"    <pattern\n" +
			"       id=\"pattern984\"\n" +
			"       patternTransform=\"translate(147.36742,176.75223)\"\n" +
			"       height=\"109.86381\"\n" +
			"       width=\"106.17338\"\n" +
			"       patternUnits=\"userSpaceOnUse\">\n" +
			"      <g\n" +
			"         transform=\"matrix(3.7795276,0,0,3.7795276,-147.36742,-176.75223)\"\n" +
			"         id=\"g146\">\n" +
			"        <path\n" +
			"           sodipodi:nodetypes=\"sscscssssssss\"\n" +
			"           d=\"m 53.735154,58.69881 c 0.01933,1.018332 0.0038,5.611617 -0.143816,6.34204 -0.275303,1.362473 -0.513146,3.135479 -0.513146,3.135479 0,0 -1.575399,-0.728212 -1.566515,-1.888372 0.0089,-1.160161 0.477443,-4.167553 0.822189,-7.16316 l -7.340042,-1.655599 c -0.499213,-0.112601 0.311445,6.742988 -1.079666,3.621804 -1.391112,-3.121184 4.839115,2.262984 4.148631,2.148899 -1.38097,-0.22817 1.376436,13.132562 0.127964,12.524235 -2.496943,-1.216652 -5.251427,-3.924172 -6.592897,-5.259099 -2.682942,-2.669855 -2.606673,-4.911805 -2.606673,-8.985865 0,-8.14812 6.637736,-14.753477 14.825798,-14.753477 8.188061,2e-6 -0.115403,10.164385 -0.08183,11.933115 z\"\n" +
			"           style=\"fill:" + headgearColor + ";stroke-width:0.264583\"\n" +
			"           id=\"path120\" />\n" +
			"        <path\n" +
			"           id=\"path120-7\"\n" +
			"           style=\"display:inline;fill:" + headgearColor + ";stroke-width:0.264583\"\n" +
			"           d=\"m 52.338476,58.748339 c -0.01933,1.018332 -0.0038,5.611617 0.143816,6.34204 0.275303,1.362473 0.513146,3.135479 0.513146,3.135479 0,0 1.575399,-0.728212 1.566515,-1.888372 -0.0089,-1.160161 -0.477443,-4.167553 -0.822189,-7.16316 l 7.340042,-1.655599 c 0.499214,-0.112601 -0.311445,6.742988 1.079667,3.621804 1.391111,-3.121184 -4.839116,2.262984 -4.148631,2.148899 1.38097,-0.22817 -1.376437,13.132563 -0.127965,12.524236 2.496943,-1.216652 5.251427,-3.924173 6.592897,-5.2591 2.682945,-2.669855 2.606675,-4.911805 2.606675,-8.985865 0,-8.14812 -6.637738,-14.753477 -14.8258,-14.753477 -8.188061,2e-6 0.115403,10.164385 0.08183,11.933115 z\"\n" +
			"           sodipodi:nodetypes=\"sscscssssssss\" />\n" +
			"      </g>\n" +
			"    </pattern>\n" +
			"  </defs>\n" +
			"  <sodipodi:namedview\n" +
			"     inkscape:window-maximized=\"0\"\n" +
			"     inkscape:window-y=\"23\"\n" +
			"     inkscape:window-x=\"0\"\n" +
			"     inkscape:window-height=\"989\"\n" +
			"     inkscape:window-width=\"1401\"\n" +
			"     showgrid=\"false\"\n" +
			"     inkscape:document-rotation=\"0\"\n" +
			"     inkscape:current-layer=\"layer1\"\n" +
			"     inkscape:document-units=\"mm\"\n" +
			"     inkscape:cy=\"382.21306\"\n" +
			"     inkscape:cx=\"361.53144\"\n" +
			"     inkscape:zoom=\"1.0155967\"\n" +
			"     inkscape:pageshadow=\"2\"\n" +
			"     inkscape:pageopacity=\"0.0\"\n" +
			"     borderopacity=\"1.0\"\n" +
			"     bordercolor=\"#666666\"\n" +
			"     pagecolor=\"#ffffff\"\n" +
			"     id=\"base\" />\n" +
			"  <metadata\n" +
			"     id=\"metadata5\">\n" +
			"    <rdf:RDF>\n" +
			"      <cc:Work\n" +
			"         rdf:about=\"\">\n" +
			"        <dc:format>image/svg+xml</dc:format>\n" +
			"        <dc:type\n" +
			"           rdf:resource=\"http://purl.org/dc/dcmitype/StillImage\" />\n" +
			"        <dc:title></dc:title>\n" +
			"      </cc:Work>\n" +
			"    </rdf:RDF>\n" +
			"  </metadata>\n" +
			"  <g\n" +
			"     id=\"layer1\"\n" +
			"     inkscape:groupmode=\"layer\"\n" +
			"     inkscape:label=\"player\">\n" +
			"    <text\n" +
			"       xml:space=\"preserve\"\n" +
			"       style=\"font-style:normal;font-weight:normal;font-size:4.58610000000000007px;line-height:1.25;font-family:sans-serif;display:inline;fill:#000000;fill-opacity:1;stroke:none;stroke-width:0.264583;text-anchor:middle;text-align:center;\"\n" +
			"       x=\"86.36763\"\n" +
			"       y=\"39.233562\"\n" +
			"       id=\"text1955-0-6\"><tspan\n" +
			"         dx=\"0 0 0 0 0 0 0 0 0\"\n" +
			"         sodipodi:role=\"line\"\n" +
			"         id=\"tspan1953-0-9\"\n" +
			"         x=\"73.5532\"\n" +
			"         y=\"39.233562\"\n" +
			"         style=\"font-size:4.58610000000000007px;stroke-width:0.264583;text-anchor:middle;text-align:center;\">" + player.getName() + " (lvl " + player.getLevel() + ")</tspan></text>\n" +
			"    <ellipse\n" +
			"       ry=\"13.132058\"\n" +
			"       rx=\"13.375244\"\n" +
			"       cy=\"59.823822\"\n" +
			"       cx=\"86.331123\"\n" +
			"       id=\"path10\"\n" +
			"       style=\"fill:#666666;stroke-width:0.234528\" />\n" +
			"    <rect\n" +
			"       ry=\"3.647794\"\n" +
			"       y=\"70.037636\"\n" +
			"       x=\"82.19696\"\n" +
			"       height=\"31.614214\"\n" +
			"       width=\"7.295588\"\n" +
			"       id=\"rect12\"\n" +
			"       style=\"fill:#666666;stroke-width:0.264583\" />\n" +
			"    <rect\n" +
			"       transform=\"rotate(25.801935)\"\n" +
			"       style=\"fill:#666666;stroke-width:0.264583\"\n" +
			"       id=\"rect12-2\"\n" +
			"       width=\"7.295588\"\n" +
			"       height=\"31.614214\"\n" +
			"       x=\"116.38419\"\n" +
			"       y=\"48.999714\"\n" +
			"       ry=\"3.647794\" />\n" +
			"    <rect\n" +
			"       ry=\"3.6477942\"\n" +
			"       y=\"123.68055\"\n" +
			"       x=\"-38.087093\"\n" +
			"       height=\"31.614214\"\n" +
			"       width=\"7.2955885\"\n" +
			"       id=\"rect12-2-2\"\n" +
			"       style=\"fill:#666666;stroke-width:0.264583\"\n" +
			"       transform=\"matrix(-0.90030407,0.4352615,0.4352615,0.90030407,0,0)\" />\n" +
			"    <rect\n" +
			"       ry=\"2.8911624\"\n" +
			"       y=\"8.3428221\"\n" +
			"       x=\"113.07696\"\n" +
			"       height=\"25.056738\"\n" +
			"       width=\"5.8589582\"\n" +
			"       id=\"rect12-2-9\"\n" +
			"       style=\"fill:#666666;stroke-width:0.211088\"\n" +
			"       transform=\"matrix(0.79692765,0.60407476,-0.75869602,0.65144481,0,0)\" />\n" +
			"    <rect\n" +
			"       transform=\"matrix(-0.79692765,0.60407476,0.75869602,0.65144481,0,0)\"\n" +
			"       style=\"fill:#666666;stroke-width:0.211088\"\n" +
			"       id=\"rect12-2-9-1\"\n" +
			"       width=\"5.8589582\"\n" +
			"       height=\"25.056738\"\n" +
			"       x=\"-1.4890016\"\n" +
			"       y=\"114.32494\"\n" +
			"       ry=\"2.8911624\" />\n" +
			"    <text\n" +
			"       xml:space=\"preserve\"\n" +
			"       style=\"font-style:normal;font-weight:normal;font-size:4.5861px;line-height:1.25;font-family:sans-serif;display:inline;fill:#000000;fill-opacity:1;stroke:none;stroke-width:0.264583\"\n" +
			"       x=\"97.851654\"\n" +
			"       y=\"102.0077\"\n" +
			"       id=\"text1955\"><tspan\n" +
			"         sodipodi:role=\"line\"\n" +
			"         id=\"tspan1953\"\n" +
			"         x=\"97.851654\"\n" +
			"         y=\"102.0077\"\n" +
			"         style=\"font-size:4.5861px;stroke-width:0.264583\">Attack: " + player.getAttackPoints() + "</tspan></text>\n" +
			"    <text\n" +
			"       id=\"text1955-0\"\n" +
			"       y=\"101.4948\"\n" +
			"       x=\"44.496502\"\n" +
			"       style=\"font-style:normal;font-weight:normal;font-size:4.5861px;line-height:1.25;font-family:sans-serif;display:inline;fill:#000000;fill-opacity:1;stroke:none;stroke-width:0.264583\"\n" +
			"       xml:space=\"preserve\"><tspan\n" +
			"         style=\"font-size:4.5861px;stroke-width:0.264583\"\n" +
			"         y=\"101.4948\"\n" +
			"         x=\"44.496502\"\n" +
			"         id=\"tspan1953-0\"\n" +
			"         sodipodi:role=\"line\">Defense: " + player.getDefensePoints() + "</tspan></text>\n" +
			"  </g>\n" +
			"  <g\n" +
			"     sodipodi:insensitive=\"true\"\n" +
			"     style=\"display:" + player.getWeapon().filter(weapon -> weapon.getType() == Weapon.Type.SWORD).map(weapon -> "inline").orElse("none") + "\"\n" +
			"     inkscape:label=\"sword\"\n" +
			"     id=\"layer2\"\n" +
			"     inkscape:groupmode=\"layer\">\n" +
			"    <path\n" +
			"       sodipodi:nodetypes=\"cccccc\"\n" +
			"       d=\"M 133.7555,55.36205 118.4711,74.887292 106.39152,87.009266 102.97346,83.695771 114.20644,70.7531 Z\"\n" +
			"       style=\"fill:url(#linearGradient75);fill-opacity:1;stroke-width:0.267958\"\n" +
			"       id=\"rect66\" />\n" +
			"    <rect\n" +
			"       transform=\"rotate(44.110068)\"\n" +
			"       y=\"-11.422952\"\n" +
			"       x=\"132.85234\"\n" +
			"       height=\"8.5338745\"\n" +
			"       width=\"3.0374804\"\n" +
			"       id=\"rect79\"\n" +
			"       style=\"fill:#808080;stroke-width:0.264583\" />\n" +
			"    <rect\n" +
			"       transform=\"rotate(44.110068)\"\n" +
			"       y=\"-13.20807\"\n" +
			"       x=\"127.06664\"\n" +
			"       height=\"3.0374804\"\n" +
			"       width=\"15.187403\"\n" +
			"       id=\"rect77\"\n" +
			"       style=\"fill:" + weaponColor + ";stroke-width:0.264583\" />\n" +
			"  </g>\n" +
			"  <g\n" +
			"     sodipodi:insensitive=\"true\"\n" +
			"     style=\"display:" + player.getWeapon().filter(weapon -> weapon.getType() == Weapon.Type.AXE).map(weapon -> "inline").orElse("none") + "\"\n" +
			"     inkscape:label=\"axe\"\n" +
			"     id=\"layer3\"\n" +
			"     inkscape:groupmode=\"layer\">\n" +
			"    <path\n" +
			"       sodipodi:nodetypes=\"sssssss\"\n" +
			"       d=\"m 111.09778,65.340075 c -2.27814,3.435873 0.95642,2.602159 2.19373,3.625398 1.23731,1.023232 1.27668,2.697907 -0.49686,9.127408 -1.56863,5.68663 7.91929,1.60781 11.52437,-3.639431 4.17728,-6.080095 5.15486,-16.193593 -0.8137,-12.514328 -4.56943,2.81679 -5.64515,3.752113 -7.23497,3.340558 -1.58981,-0.411549 -2.33491,-4.219331 -5.17257,0.06039 z\"\n" +
			"       style=\"fill:url(#linearGradient96);fill-opacity:1;stroke-width:0.264583\"\n" +
			"       id=\"path88\" />\n" +
			"    <rect\n" +
			"       transform=\"matrix(-0.83344068,-0.55260893,-0.55260893,0.83344068,0,0)\"\n" +
			"       y=\"-13.87937\"\n" +
			"       x=\"-133.90804\"\n" +
			"       height=\"38.619396\"\n" +
			"       width=\"2.1696289\"\n" +
			"       id=\"rect99\"\n" +
			"       style=\"fill:" + weaponColor + ";stroke-width:0.264583\" />\n" +
			"  </g>\n" +
			"  <g\n" +
			"     style=\"display:" + player.getHeadgear().filter(headgear -> headgear.getType() == Headgear.Type.HELMET).map(weapon -> "inline").orElse("none") + "\"\n" +
			"     inkscape:label=\"helmet\"\n" +
			"     id=\"layer4\"\n" +
			"     inkscape:groupmode=\"layer\">\n" +
			"    <path\n" +
			"       d=\"M 71.993239,44.470572 H 100.08494 V 73.538704 H 71.993239 Z\"\n" +
			"       style=\"fill:url(#pattern1949);stroke:none;stroke-width:0.264583\"\n" +
			"       id=\"rect989\" />\n" +
			"  </g>\n" +
			"</svg>";
	}

}