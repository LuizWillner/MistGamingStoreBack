package com.willner.mist_gaming_store;

import com.willner.mist_gaming_store.model.CategoryModel;
import com.willner.mist_gaming_store.model.GameModel;
import com.willner.mist_gaming_store.model.UserModel;
import com.willner.mist_gaming_store.repository.ICategoryRepository;
import com.willner.mist_gaming_store.repository.IGameRepository;
import com.willner.mist_gaming_store.repository.IUserRepository;
import com.willner.mist_gaming_store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;


@SpringBootApplication
public class MistGamingStoreApplication implements CommandLineRunner {

	@Autowired
	UserService userService;

	@Autowired
	IUserRepository userRepository;

	@Autowired
	IGameRepository gameRepository;

	@Autowired
	ICategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(MistGamingStoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Aplicação rodando...");

		UserModel user = new UserModel("admin@email.com", "Admin", "senha");
		this.userRepository.save(user);

		CategoryModel catRpgAcao = new CategoryModel("RPG Ação");
		this.categoryRepository.save(catRpgAcao);
		CategoryModel catCrpg = new CategoryModel("CRPG");
		this.categoryRepository.save(catCrpg);
		CategoryModel catCoop = new CategoryModel("Coop");
		this.categoryRepository.save(catCoop);
		CategoryModel catMoba = new CategoryModel("MOBA");
		this.categoryRepository.save(catMoba);
		CategoryModel catAcaoEAventura = new CategoryModel("Ação e Aventura");
		this.categoryRepository.save(catAcaoEAventura);
		CategoryModel catMundoAberto = new CategoryModel("Mundo Aberto");
		this.categoryRepository.save(catMundoAberto);
		CategoryModel catFps = new CategoryModel("FPS");
		this.categoryRepository.save(catFps);

		GameModel game = new GameModel(
			"Baldur's Gate 3",
			"PATH",
			"Baldur's Gate III é um jogo eletrônico de RPG desenvolvido e publicado pela Larian Studios. É o terceiro jogo principal da série Baldur's Gate, que é baseada no sistema de RPG de mesa Dungeons & Dragons, dentro do cenário de Forgotten Realms",
			"Larian Studios",
			"Larian Studios",
			new BigDecimal("160.0"),
			LocalDate.of(2023, 8, 3),
			50,
			catCrpg
		);
		this.gameRepository.save(game);

		game = new GameModel(
			"Helldivers 2",
			"PATH",
			"For DEMOCRACY!",
			"Arrow Head",
			"Sony Interactive Entertainment",
			new BigDecimal("200.0"),
			LocalDate.of(2024, 2, 8),
			100,
			catCoop
		);
		this.gameRepository.save(game);

		game = new GameModel(
			"A Way Out",
			"PATH",
			"A Way Out é um jogo eletrônico de ação-aventura desenvolvido pela Hazelight Studios e publicado pela Electronic Arts sob o selo EA Originals. É o segundo jogo dirigido por Josef Fares após seu trabalho em Brothers: A Tale of Two Sons.",
			"Hazelight Studios",
			"Eletronic Arts",
			new BigDecimal("30.0"),
			LocalDate.of(2018, 3, 23),
			100,
			catCoop
		);
		this.gameRepository.save(game);

		game = new GameModel(
			"League of Legends",
			"PATH",
			"League of Legends é um jogo de estratégia em que duas equipes de cinco poderosos Campeões se enfrentam para destruir a base uma da outra. Escolha entre mais de 140 Campeões para realizar jogadas épicas, assegurar abates e destruir torres conforme você luta até a vitória.",
			"Riot Games",
			"Riot Games",
			new BigDecimal("0.0"),
			LocalDate.of(2009, 10, 27),
			1000000,
			catMoba
		);
		this.gameRepository.save(game);

		game = new GameModel(
			"DOTA 2",
			"PATH",
			"Dota 2 é um jogo eletrônico do gênero multiplayer online battle arena (MOBA) desenvolvido e publicado pela Valve. Lançado em 2013, o jogo é uma sequência de Defense of the Ancients (DotA), uma modificação criada pela comunidade para o jogo Warcraft III: Reign of Chaos, da Blizzard Entertainment.",
			"Blizzard",
			"Blizzard",
			new BigDecimal("0.0"),
			LocalDate.of(2013, 7, 9),
			1000000,
			catMoba
		);
		this.gameRepository.save(game);

		game = new GameModel(
			"God of War",
			"PATH",
			"God of War é um jogo eletrônico de ação-aventura desenvolvido pela Santa Monica Studio e publicado pela Sony Interactive Entertainment. Foi lançado em 20 de abril de 2018 para PlayStation 4 e em 14 de janeiro de 2022 para Microsoft Windows.",
			"Santa Monica Studios",
			"Sony Interactive Entertainment",
			new BigDecimal("120.0"),
			LocalDate.of(2018, 4, 20),
			100,
			catAcaoEAventura
		);
		this.gameRepository.save(game);

		game = new GameModel(
			"The Last of Us Part I",
			"PATH",
			"The Last of Us Part I é um jogo eletrônico de ação-aventura de 2022 desenvolvido pela Naughty Dog e publicado pela Sony Interactive Entertainment. É um remake de The Last of Us, apresentando jogabilidade e controles revisados, incluindo combate e exploração aprimorados e opções de acessibilidade expandidas.",
			"Naughty Dog",
			"Sony Interactive Entertainment",
			new BigDecimal("230.0"),
			LocalDate.of(2022, 9, 2),
			100,
			catAcaoEAventura
		);
		this.gameRepository.save(game);

		game = new GameModel(
			"The Witcher 3",
			"PATH",
			"The Witcher 3: Wild Hunt é um jogo eletrônico de RPG de ação em mundo aberto desenvolvido pela CD Projekt RED e lançado no dia 19 de maio de 2015 para as plataformas Microsoft Windows, PlayStation 4, Xbox One e em outubro de 2019 para o Nintendo Switch, sendo o terceiro título da série de jogos The Witcher.",
			"CD Projekt Red",
			"CD Projekt Red",
			new BigDecimal("100.0"),
			LocalDate.of(2015, 5, 18),
			100,
			catRpgAcao
		);
		this.gameRepository.save(game);

		game = new GameModel(
			"Uncharted 4",
			"PATH",
			"Uncharted 4: A Thief's End é um jogo eletrônico de ação-aventura desenvolvido pela Naughty Dog e publicado pela Sony Computer Entertainment. É o quarto título principal da série Uncharted e foi lançado exclusivamente para PlayStation 4 em 10 de maio de 2016",
			"Naughty Dog",
			"Sony Interactive Entertainment",
			new BigDecimal("150.0"),
			LocalDate.of(2016, 5, 10),
			100,
			catAcaoEAventura
		);
		this.gameRepository.save(game);

		game = new GameModel(
			"Ghost of Tsushima",
			"PATH",
			"Ghost of Tsushima é um jogo eletrônico de ação-aventura desenvolvido pela Sucker Punch Productions e publicado pela Sony Interactive Entertainment. A história acompanha Jin Sakai, um samurai que precisa proteger a Ilha de Tsushima durante a primeira invasão mongol do Japão.",
			"Sucker Punch Productions",
			"Sony Interactive Entertainment",
			new BigDecimal("200.0"),
			LocalDate.of(2020, 7, 17),
			100,
			catMundoAberto
		);
		this.gameRepository.save(game);

		game = new GameModel(
			"The Last of Us Part II",
			"PATH",
			"The Last of Us Part II é um jogo eletrônico de ação-aventura desenvolvido pela Naughty Dog e publicado pela Sony Interactive Entertainment. É o segundo jogo da franquia e foi lançado em 19 de junho de 2020 exclusivamente para PlayStation 4.",
			"Naughty Dog",
			"Sony Interactive Entertainment",
			new BigDecimal("200.0"),
			LocalDate.of(2020, 6, 19),
			100,
			catAcaoEAventura
		);
		this.gameRepository.save(game);

		game = new GameModel(
			"God of War: Ragnarok",
			"PATH",
			"God of War Ragnarök é um jogo eletrônico de ação-aventura desenvolvido pela Santa Monica Studio e publicado pela Sony Interactive Entertainment. Foi lançado em 9 de novembro de 2022 para PlayStation 4 e PlayStation 5. Uma versão foi lançado para o Windows em 19 de setembro de 2024.",
			"Santa Monica Studios",
			"Sony Interactive Entertainment",
			new BigDecimal("230.0"),
			LocalDate.of(2024, 9, 19),
			100,
			catAcaoEAventura
		);
		this.gameRepository.save(game);

		game = new GameModel(
			"Star Wars: Knights of The Old Republic",
			"PATH",
			"Star Wars: Cavaleiros da Velha República é um jogo eletrônico de RPG desenvolvido em 2003 pela Aspyr para computador com o sistema Apple Macintosh, e pela BioWare para videogame Xbox em julho de 2003 e para computador com o sistema Microsoft Windows em novembro de 2003 e, publicado pela LucasArts e Disney.",
			"Bioware",
			"LucasArts",
			new BigDecimal("10.0"),
			LocalDate.of(2003, 7, 15),
			100,
			catCrpg
		);
		this.gameRepository.save(game);

	}
}
