package com.willner.mist_gaming_store.util;

import com.willner.mist_gaming_store.model.CartModel;
import com.willner.mist_gaming_store.model.CategoryModel;
import com.willner.mist_gaming_store.model.GameModel;
import com.willner.mist_gaming_store.model.UserModel;
import com.willner.mist_gaming_store.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;


@Component
public class DBUtils {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IGameRepository gameRepository;

    @Autowired
    ICategoryRepository categoryRepository;

    @Autowired
    ICartRepository cartRepository;

    @Autowired
    ICartItemRepository cartItemRepository;

    public void populateDB() {
        UserModel user = new UserModel("admin@email.com", "Admin", "senha");
        this.userRepository.save(user);

        CartModel cart = new CartModel(user);
        this.cartRepository.save(cart);

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
        CategoryModel catHeroShooter = new CategoryModel("Hero Shooter");
        this.categoryRepository.save(catHeroShooter);
        CategoryModel catEsportes = new CategoryModel("Esportes");
        this.categoryRepository.save(catEsportes);
        CategoryModel catMmorpg = new CategoryModel("MMORPG");
        this.categoryRepository.save(catMmorpg);
        CategoryModel catSoulsLike = new CategoryModel("Souls Like");
        this.categoryRepository.save(catSoulsLike);

        GameModel game = new GameModel(
                "Baldur's Gate 3",
                "PATH",
                "Baldur's Gate III é um RPG desenvolvido e publicado pela Larian Studios. É o terceiro jogo principal da série Baldur's Gate, que é baseada no sistema de RPG de mesa Dungeons & Dragons, dentro do cenário de Forgotten Realms",
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
                "A Way Out é um jogo de ação-aventura desenvolvido pela Hazelight Studios e publicado pela Electronic Arts sob o selo EA Originals. É o segundo jogo dirigido por Josef Fares após seu trabalho em Brothers: A Tale of Two Sons.",
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
                "Dota 2 é um jogo do gênero multiplayer online battle arena (MOBA) desenvolvido e publicado pela Valve. Lançado em 2013, o jogo é uma sequência de Defense of the Ancients (DotA), uma modificação criada pela comunidade para o jogo Warcraft III: Reign of Chaos, da Blizzard Entertainment.",
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
                "God of War é um jogo de ação-aventura desenvolvido pela Santa Monica Studio e publicado pela Sony Interactive Entertainment. Foi lançado em 20 de abril de 2018 para PlayStation 4 e em 14 de janeiro de 2022 para Microsoft Windows.",
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
                "The Last of Us Part I é um jogo de ação-aventura de 2022 desenvolvido pela Naughty Dog e publicado pela Sony Interactive Entertainment. É um remake de The Last of Us, apresentando jogabilidade e controles revisados, incluindo combate e exploração aprimorados e opções de acessibilidade expandidas.",
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
                "The Witcher 3: Wild Hunt é um RPG de ação em mundo aberto desenvolvido pela CD Projekt RED e lançado no dia 19 de maio de 2015 para as plataformas Microsoft Windows, PlayStation 4, Xbox One e em outubro de 2019 para o Nintendo Switch, sendo o terceiro título da série de jogos The Witcher.",
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
                "Uncharted 4: A Thief's End é um jogo de ação-aventura desenvolvido pela Naughty Dog e publicado pela Sony Computer Entertainment. É o quarto título principal da série Uncharted e foi lançado exclusivamente para PlayStation 4 em 10 de maio de 2016",
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
                "Ghost of Tsushima é um jogo em mundo aberto de ação-aventura desenvolvido pela Sucker Punch Productions e publicado pela Sony Interactive Entertainment. A história acompanha Jin Sakai, um samurai que precisa proteger a Ilha de Tsushima durante a primeira invasão mongol do Japão.",
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
                "The Last of Us Part II é um jogo de ação-aventura desenvolvido pela Naughty Dog e publicado pela Sony Interactive Entertainment. É o segundo jogo da franquia e foi lançado em 19 de junho de 2020 exclusivamente para PlayStation 4.",
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
                "God of War Ragnarök é um jogo de ação-aventura desenvolvido pela Santa Monica Studio e publicado pela Sony Interactive Entertainment. Foi lançado em 9 de novembro de 2022 para PlayStation 4 e PlayStation 5. Uma versão foi lançado para o Windows em 19 de setembro de 2024.",
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
                "Star Wars: Cavaleiros da Velha República é um RPG desenvolvido em 2003 pela Aspyr para computador com o sistema Apple Macintosh, e pela BioWare para videogame Xbox em julho de 2003 e para computador com o sistema Microsoft Windows em novembro de 2003 e, publicado pela LucasArts e Disney.",
                "Bioware",
                "LucasArts",
                new BigDecimal("10.0"),
                LocalDate.of(2003, 7, 15),
                100,
                catCrpg
        );
        this.gameRepository.save(game);

        game = new GameModel(
                "Counter-Strike: Global Offensive",
                "PATH",
                "Counter-Strike: Global Offensive é um jogo de tiro em primeira pessoa online desenvolvido pela Valve Corporation. É o quarto jogo principal da série Counter-Strike e foi lançado para Microsoft Windows, OS X, Xbox 360 e PlayStation 3 em 21 de agosto de 2012.",
                "Valve Corporation",
                "Valve Corporation",
                new BigDecimal("0.0"),
                LocalDate.of(2012, 8, 21),
                1000000,
                catFps
        );
        this.gameRepository.save(game);

        game = new GameModel(
                "Valorant",
                "PATH",
                "Valorant é um jogo eletrônico multijogador gratuito para jogar de tiro em primeira pessoa desenvolvido e publicado pela Riot Games. O jogo foi anunciado com o codinome Project A em outubro de 2019 e foi lançado em 2 de junho de 2020.",
                "Riot Games",
                "Riot Games",
                new BigDecimal("0.0"),
                LocalDate.of(2020, 6, 2),
                1000000,
                catHeroShooter
        );
        this.gameRepository.save(game);

        game = new GameModel(
                "Overwatch",
                "PATH",
                "Overwatch é um jogo eletrônico multijogador de tiro em primeira pessoa desenvolvido e publicado pela Blizzard Entertainment. Revelado na BlizzCon de 2014, o jogo enfatiza a jogabilidade cooperativa usando uma série de personagens diversos, cada um com suas próprias habilidades e funções no campo de batalha.",
                "Blizzard",
                "Blizzard",
                new BigDecimal("0.0"),
                LocalDate.of(2016, 5, 24),
                1000000,
                catHeroShooter
        );
        this.gameRepository.save(game);

        game = new GameModel(
            "Cyberpunk 2077",
            "PATH",
            "Cyberpunk 2077 é um RPG de ação e aventura em mundo aberto que se passa em Night City, uma megalópole perigosa onde todos são obcecados por poder, glamour e alterações corporais.",
            "CD Projekt Red",
            "CD Projekt Red",
            new BigDecimal("200.0"),
            LocalDate.of(2020, 12, 9),
            100,
            catMundoAberto
        );
        this.gameRepository.save(game);

        game = new GameModel(
            "The Elder Scrolls V: Skyrim",
            "PATH",
            "The Elder Scrolls V: Skyrim é um RPG eletrônico de ação desenvolvido pela Bethesda Game Studios e publicado pela Bethesda Softworks. É o quinto jogo principal da série The Elder Scrolls, seguindo The Elder Scrolls IV: Oblivion.",
            "Bethesda Game Studios",
            "Bethesda Softworks",
            new BigDecimal("100.0"),
            LocalDate.of(2011, 11, 11),
            100,
            catRpgAcao
        );
        this.gameRepository.save(game);

        game = new GameModel(
                "EA Sports FC 25",
                "PATH",
                "EA Sports FC 25 é um jogo de futebol desenvolvido pela EA Sports. O jogo é uma simulação de futebol e é o 25º título da série EA Sports FC.",
                "EA Canada & EA Romania",
                "EA Sports",
                new BigDecimal("300.0"),
                LocalDate.of(2024, 9, 27),
                100,
                catEsportes
        );
        this.gameRepository.save(game);

        game = new GameModel(
                "World of Warcraft",
                "PATH",
                "World of Warcraft é um jogo eletrônico de RPG online desenvolvido e publicado pela Blizzard Entertainment. É o quarto jogo lançado ambientado no universo fantástico de Warcraft, que foi introduzido pelo primeiro título, Warcraft: Orcs & Humans, em 1994.",
                "Blizzard",
                "Blizzard",
                new BigDecimal("0.0"),
                LocalDate.of(2004, 11, 23),
                1000000,
                catMmorpg
        );
        this.gameRepository.save(game);

        game = new GameModel(
                "Red Dead Redemption 2",
                "PATH",
                "Red Dead Redemption 2 é um jogo de mundo aberto que se passa no velho oeste e desenvolvido e publicado pela Rockstar Games. É o terceiro título da série Red Dead e uma prequela de Red Dead Redemption.",
                "Rockstar Games",
                "Rockstar Games",
                new BigDecimal("200.0"),
                LocalDate.of(2018, 10, 26),
                100,
                catMundoAberto
        );
        this.gameRepository.save(game);

        game = new GameModel(
                "Dark Souls III",
                "PATH",
                "DARK SOULS™ continua a ultrapassar seus próprios limites em um ambicioso novo capítulo da série que definiu um gênero e que é aclamada pela crítica. Prepare-se para abraçar a escuridão!",
                "FromSoftware",
                "Bandai Namco Entertainment",
                new BigDecimal("100.0"),
                LocalDate.of(2016, 3, 24),
                100,
                catSoulsLike
        );
        this.gameRepository.save(game);

        game = new GameModel(
                "Bloodborne",
                "PATH",
                "Perigo, morte e loucura estão em cada canto deste sombrio e horroroso mundo, e você deve descobrir seus segredos mais sombrios para sobreviver. -Um aterrorizante mundo novo: Faça uma jornada para uma cidade gótica cheia de horror, onde multidões loucas e criaturas assustadoras espreitam em cada canto.",
                "FromSoftware",
                "Sony Interactive Entertainment",
                new BigDecimal("150.0"),
                LocalDate.of(2015, 3, 24),
                100,
                catSoulsLike
        );
        this.gameRepository.save(game);

        game = new GameModel(
                "Sekiro: Shadows Die Twice",
                "PATH",
                "Em Sekiro: Shadows Die Twice você é o 'lobo de um braço só', um guerreiro desfigurado e desgraçado resgatado da beira da morte. Destinado a proteger um jovem senhor descendente de uma antiga linhagem, você se tornará alvo de muitos inimigos cruéis, incluindo o perigoso clã Ashina.",
                "FromSoftware",
                "Activision",
                new BigDecimal("200.0"),
                LocalDate.of(2019, 3, 21),
                100,
                catSoulsLike
        );
        this.gameRepository.save(game);

        game = new GameModel(
                "Elden Ring",
                "PATH",
                "Levante-se, Maculado, e seja guiado pela graça para portar o poder do Anel Prístino e se tornar um Lorde Prístino nas Terras Intermédias. Em Elden Ring, junte-se a um mundo cheio de mistérios e perigos, e embarque em uma jornada épica para desvendar o destino do Reino.",
                "FromSoftware",
                "Bandai Namco Entertainment",
                new BigDecimal("250.0"),
                LocalDate.of(2022, 2, 24),
                100,
                catSoulsLike
        );
        this.gameRepository.save(game);
    }
}
