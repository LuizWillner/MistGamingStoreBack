package com.willner.mist_gaming_store.util;

import com.willner.mist_gaming_store.model.*;
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
                "https://bg3.wiki/w/images/8/89/Baldur%27s_Gate_3_Cover_Art.webp",
                "https://www.youtube.com/embed/UgTFtD2sHdE?si=GoS-ahlUIiukpY9q",
                "Baldur's Gate III é um RPG desenvolvido e publicado pela Larian Studios. É o terceiro jogo principal da série Baldur's Gate, que é baseada no sistema de RPG de mesa Dungeons & Dragons, dentro do cenário de Forgotten Realms",
                "Larian Studios",
                "Larian Studios",
                new BigDecimal("200.0"),
                0.2,
                LocalDate.of(2023, 8, 3),
                50,
                catCrpg
        );
        this.gameRepository.save(game);

        game = new GameModel(
                "Helldivers 2",
                "https://assetsio.gnwcdn.com/co6jbi.jpg",
                "https://www.youtube.com/embed/UC5EpJR0GBQ",
                "For DEMOCRACY!",
                "Arrow Head",
                "Sony Interactive Entertainment",
                new BigDecimal("200.0"),
                0.0,
                LocalDate.of(2024, 2, 8),
                100,
                catCoop
        );
        this.gameRepository.save(game);

        game = new GameModel(
                "A Way Out",
                "https://cdn1.epicgames.com/spt-assets/a037fc78ee9d47b98466f17b44c46288/a-way-out-kd107.jpg",
                "https://www.youtube.com/embed/-r5fY05t_7g?si=x7OzGqNL5RLFvDkT",
                "A Way Out é um jogo de ação-aventura desenvolvido pela Hazelight Studios e publicado pela Electronic Arts sob o selo EA Originals. É o segundo jogo dirigido por Josef Fares após seu trabalho em Brothers: A Tale of Two Sons.",
                "Hazelight Studios",
                "Eletronic Arts",
                new BigDecimal("60.0"),
                0.5,
                LocalDate.of(2018, 3, 23),
                100,
                catCoop
        );
        this.gameRepository.save(game);

        game = new GameModel(
                "League of Legends",
                "https://i.pinimg.com/736x/2e/b8/f2/2eb8f2e12a58c48cc5074d4526cf589a.jpg",
                "https://www.youtube.com/embed/vzHrjOMfHPY?si=MKrviwDQvV9m_69n",
                "League of Legends é um jogo de estratégia em que duas equipes de cinco poderosos Campeões se enfrentam para destruir a base uma da outra. Escolha entre mais de 140 Campeões para realizar jogadas épicas, assegurar abates e destruir torres conforme você luta até a vitória.",
                "Riot Games",
                "Riot Games",
                new BigDecimal("0.0"),
                0.0,
                LocalDate.of(2009, 10, 27),
                1000000,
                catMoba
        );
        this.gameRepository.save(game);

        game = new GameModel(
                "DOTA 2",
                "https://i.pinimg.com/736x/d1/59/e9/d159e9ca272b73f56ef2b770a7c0b17b.jpg",
                "https://www.youtube.com/embed/SmnqsdeHFT0?si=BgwKOMAEy_mRyr8j",
                "Dota 2 é um jogo do gênero multiplayer online battle arena (MOBA) desenvolvido e publicado pela Valve. Lançado em 2013, o jogo é uma sequência de Defense of the Ancients (DotA), uma modificação criada pela comunidade para o jogo Warcraft III: Reign of Chaos, da Blizzard Entertainment.",
                "Blizzard",
                "Blizzard",
                new BigDecimal("0.0"),
                0.0,
                LocalDate.of(2013, 7, 9),
                1000000,
                catMoba
        );
        this.gameRepository.save(game);

        game = new GameModel(
                "God of War",
                "https://cdn1.epicgames.com/offer/3ddd6a590da64e3686042d108968a6b2/EGS_GodofWar_SantaMonicaStudio_S2_1200x1600-fbdf3cbc2980749091d52751ffabb7b7_1200x1600-fbdf3cbc2980749091d52751ffabb7b7",
                "https://www.youtube.com/embed/FyIwEFXOcaE?si=ZcNyIx0vbLfw7tej",
                "God of War é um jogo de ação-aventura desenvolvido pela Santa Monica Studio e publicado pela Sony Interactive Entertainment. Foi lançado em 20 de abril de 2018 para PlayStation 4 e em 14 de janeiro de 2022 para Microsoft Windows.",
                "Santa Monica Studios",
                "Sony Interactive Entertainment",
                new BigDecimal("200.0"),
                0.4,
                LocalDate.of(2018, 4, 20),
                100,
                catAcaoEAventura
        );
        this.gameRepository.save(game);

        game = new GameModel(
                "The Last of Us: Part I",
                "https://cdn1.epicgames.com/offer/0c40923dd1174a768f732a3b013dcff2/EGS_TheLastofUsPartI_NaughtyDogLLC_S2_1200x1600-41d1b88814bea2ee8cb7986ec24713e0",
                "https://www.youtube.com/embed/R2Ebc_OFeug",
                "The Last of Us Part I é um jogo de ação-aventura de 2022 desenvolvido pela Naughty Dog e publicado pela Sony Interactive Entertainment. É um remake de The Last of Us, apresentando jogabilidade e controles revisados, incluindo combate e exploração aprimorados e opções de acessibilidade expandidas.",
                "Naughty Dog",
                "Sony Interactive Entertainment",
                new BigDecimal("230.0"),
                0.0,
                LocalDate.of(2022, 9, 2),
                100,
                catAcaoEAventura
        );
        this.gameRepository.save(game);
        CartItemModel cartItem = new CartItemModel(3, cart, game);
        this.cartItemRepository.save(cartItem);

        game = new GameModel(
                "The Witcher 3",
                "https://assetsio.gnwcdn.com/co1wyy.jpg?width=1200&height=1200&fit=bounds&quality=70&format=jpg&auto=webp",
                "https://www.youtube.com/embed/53MyR_Z3i1w?si=6pnopt33d-flMhKi",
                "The Witcher 3: Wild Hunt é um RPG de ação em mundo aberto desenvolvido pela CD Projekt RED e lançado no dia 19 de maio de 2015 para as plataformas Microsoft Windows, PlayStation 4, Xbox One e em outubro de 2019 para o Nintendo Switch, sendo o terceiro título da série de jogos The Witcher.",
                "CD Projekt Red",
                "CD Projekt Red",
                new BigDecimal("200.0"),
                0.5,
                LocalDate.of(2015, 5, 18),
                100,
                catRpgAcao
        );
        this.gameRepository.save(game);
        cartItem = new CartItemModel(1, cart, game);
        this.cartItemRepository.save(cartItem);

        game = new GameModel(
                "Uncharted 4",
                "https://assetsio.gnwcdn.com/co1r7h.jpg?width=1200&height=1200&fit=bounds&quality=70&format=jpg&auto=webp",
                "https://www.youtube.com/embed/hh5HV4iic1Y?si=Juqg1sP6gt7hKxsx",
                "Uncharted 4: A Thief's End é um jogo de ação-aventura desenvolvido pela Naughty Dog e publicado pela Sony Computer Entertainment. É o quarto título principal da série Uncharted e foi lançado exclusivamente para PlayStation 4 em 10 de maio de 2016",
                "Naughty Dog",
                "Sony Interactive Entertainment",
                new BigDecimal("200.0"),
                0.25,
                LocalDate.of(2016, 5, 10),
                100,
                catAcaoEAventura
        );
        this.gameRepository.save(game);

        game = new GameModel(
                "Ghost of Tsushima",
                "https://i.pinimg.com/736x/3b/3f/ff/3b3fffdd728e24ea178d41e175a018ac.jpg",
                "https://www.youtube.com/embed/Zbq7BnsQhrw?si=oBFguZN321cUDkcN",
                "Ghost of Tsushima é um jogo em mundo aberto de ação-aventura desenvolvido pela Sucker Punch Productions e publicado pela Sony Interactive Entertainment. A história acompanha Jin Sakai, um samurai que precisa proteger a Ilha de Tsushima durante a primeira invasão mongol do Japão.",
                "Sucker Punch Productions",
                "Sony Interactive Entertainment",
                new BigDecimal("200.0"),
                0.0,
                LocalDate.of(2020, 7, 17),
                100,
                catMundoAberto
        );
        this.gameRepository.save(game);

        game = new GameModel(
                "The Last of Us Part II",
                "https://cdn1.epicgames.com/offer/7713e3fa4b234e0d8f553044205d53b6/EGS_TheLastofUsPartIIRemastered_NaughtyDogLLCNixxesSoftwareIronGalaxy_S2_1200x1600-2e13755a6b3fec2ee9dbcc231a1cf39c",
                "https://www.youtube.com/embed/W2Wnvvj33Wo?si=7TQ902rzADbeakTb",
                "The Last of Us Part II é um jogo de ação-aventura desenvolvido pela Naughty Dog e publicado pela Sony Interactive Entertainment. É o segundo jogo da franquia e foi lançado em 19 de junho de 2020 exclusivamente para PlayStation 4.",
                "Naughty Dog",
                "Sony Interactive Entertainment",
                new BigDecimal("200.0"),
                0.0,
                LocalDate.of(2020, 6, 19),
                100,
                catAcaoEAventura
        );
        this.gameRepository.save(game);

        game = new GameModel(
                "God of War: Ragnarok",
                "https://cdn1.epicgames.com/spt-assets/edaff839f0734d16bc89d2ddb1dc9339/steel-magnolia-xbf3x.jpg",
                "https://www.youtube.com/embed/hfJ4Km46A-0",
                "God of War Ragnarök é um jogo de ação-aventura desenvolvido pela Santa Monica Studio e publicado pela Sony Interactive Entertainment. Foi lançado em 9 de novembro de 2022 para PlayStation 4 e PlayStation 5. Uma versão foi lançado para o Windows em 19 de setembro de 2024.",
                "Santa Monica Studios",
                "Sony Interactive Entertainment",
                new BigDecimal("230.0"),
                0.0,
                LocalDate.of(2024, 9, 19),
                100,
                catAcaoEAventura
        );
        this.gameRepository.save(game);

        game = new GameModel(
                "Star Wars: Knights of The Old Republic",
                "https://static.wikia.nocookie.net/ptstarwars/images/5/51/Knightsoftheoldrepublic_capa.png",
                "https://www.youtube.com/embed/aw9RaACjZmM",
                "Star Wars: Cavaleiros da Velha República é um RPG desenvolvido pela Bioware e publicado pela LucasArts. A história do jogo começa quatro mil anos antes da ascensão do império galático (período referente a história dos filmes clássicos), quando o Ex-jedi Darth Malak e seu aprendiz Darth Revan lideram um ataque contra a República trazendo toda a Armada Sith para uma guerra contra os Jedis.",
                "Bioware",
                "LucasArts",
                new BigDecimal("25.0"),
                0.0,
                LocalDate.of(2003, 7, 15),
                100,
                catCrpg
        );
        this.gameRepository.save(game);

        game = new GameModel(
                "Counter-Strike: Global Offensive",
                "https://vortexcultural.com.br/images/2012/10/Counter-Strike-Global-Offensive.jpg",
                "https://www.youtube.com/embed/edYCtaNueQY",
                "Counter-Strike: Global Offensive é um jogo de tiro em primeira pessoa online desenvolvido pela Valve Corporation. É o quarto jogo principal da série Counter-Strike e foi lançado para Microsoft Windows, OS X, Xbox 360 e PlayStation 3 em 21 de agosto de 2012.",
                "Valve Corporation",
                "Valve Corporation",
                new BigDecimal("0.0"),
                0.0,
                LocalDate.of(2012, 8, 21),
                1000000,
                catFps
        );
        this.gameRepository.save(game);

        game = new GameModel(
                "Valorant",
                "https://bdjogos.com.br/capas/9316-valorant-pc-capa-1.jpg",
                "https://www.youtube.com/embed/e_E9W2vsRbQ",
                "Valorant é um jogo eletrônico multijogador gratuito para jogar de tiro em primeira pessoa desenvolvido e publicado pela Riot Games. O jogo foi anunciado com o codinome Project A em outubro de 2019 e foi lançado em 2 de junho de 2020.",
                "Riot Games",
                "Riot Games",
                new BigDecimal("0.0"),
                0.0,
                LocalDate.of(2020, 6, 2),
                1000000,
                catHeroShooter
        );
        this.gameRepository.save(game);

        game = new GameModel(
                "Marvel Rivals",
                "https://cdn1.epicgames.com/spt-assets/eb15454c010f4a748498cd3a62096a52/marvel-rivals-wq3mr.png",
                "https://www.youtube.com/embed/-b0veB7q9P4",
                "Marvel Rivals é um jogo de tiro JxJ em equipe com Super Heróis! Reúna um grupo de estrelas da Marvel, crie estratégias e combine seus poderes para executar poderosas habilidades de equipe.",
                "NetEase Games",
                "NetEase Games",
                new BigDecimal("0.0"),
                0.0,
                LocalDate.of(2024, 12, 5),
                1000000,
                catHeroShooter
        );
        this.gameRepository.save(game);
        cartItem = new CartItemModel(1, cart, game);
        this.cartItemRepository.save(cartItem);

        game = new GameModel(
            "Cyberpunk 2077",
            "https://cdn1.epicgames.com/offer/77f2b98e2cef40c8a7437518bf420e47/EGS_Cyberpunk2077_CDPROJEKTRED_S2_03_1200x1600-b1847981214ac013383111fc457eb9c5",
            "https://www.youtube.com/embed/8X2kIfS6fb8",
            "Cyberpunk 2077 é um RPG de ação e aventura em mundo aberto que se passa em Night City, uma megalópole perigosa onde todos são obcecados por poder, glamour e alterações corporais.",
            "CD Projekt Red",
            "CD Projekt Red",
            new BigDecimal("200.0"),
            0.0,
            LocalDate.of(2020, 12, 9),
            100,
            catMundoAberto
        );
        this.gameRepository.save(game);

//        game = new GameModel(
//            "The Elder Scrolls V: Skyrim",
//            "https://cdn1.epicgames.com/offer/c8738a4d1ead40368eab9688b3c7d737/EGS_SkyrimSpecialEdition_BethesdaGameStudios_S2_1200x1600-ae5d13f6510e81460fe80aa1ca19cf4c",
//            "https://www.youtube.com/embed/JSRtYpNRoN0&t=8s",
//            "The Elder Scrolls V: Skyrim é um RPG eletrônico de ação desenvolvido pela Bethesda Game Studios e publicado pela Bethesda Softworks. É o quinto jogo principal da série The Elder Scrolls, seguindo The Elder Scrolls IV: Oblivion.",
//            "Bethesda Game Studios",
//            "Bethesda Softworks",
//            new BigDecimal("200.0"),
//            0.4,
//            LocalDate.of(2011, 11, 11),
//            100,
//            catRpgAcao
//        );
//        this.gameRepository.save(game);

        game = new GameModel(
                "EA Sports FC 25",
                "https://cdn1.epicgames.com/offer/b61e8ddd14e94619b7a74cf9d73f86b5/EGS_EASPORTSFC25StandardEdition_EACanada_S2_1200x1600-6e6b5c1d5d30e15b1dbdde721c6bc544",
                "https://www.youtube.com/embed/JSRtYpNRoN0",
                "EA Sports FC 25 é um jogo de futebol desenvolvido pela EA Sports. O jogo é uma simulação de futebol e é o 25º título da série EA Sports FC.",
                "EA Canada & EA Romania",
                "EA Sports",
                new BigDecimal("300.0"),
                0.0,
                LocalDate.of(2024, 9, 27),
                100,
                catEsportes
        );
        this.gameRepository.save(game);

        game = new GameModel(
                "World of Warcraft",
                "https://i.ebayimg.com/00/s/MTYwMFgxMDY2/z/iVAAAOSwP0JdcVlR/$_57.JPG?set_id=8800005007",
                "https://www.youtube.com/embed/vlVSJ0AvZe0",
                "World of Warcraft é um jogo eletrônico de RPG online desenvolvido e publicado pela Blizzard Entertainment. É o quarto jogo lançado ambientado no universo fantástico de Warcraft, que foi introduzido pelo primeiro título, Warcraft: Orcs & Humans, em 1994.",
                "Blizzard",
                "Blizzard",
                new BigDecimal("0.0"),
                0.0,
                LocalDate.of(2004, 11, 23),
                1000000,
                catMmorpg
        );
        this.gameRepository.save(game);

        game = new GameModel(
                "Red Dead Redemption 2",
                "https://cdn1.epicgames.com/epic/offer/RDR2PC1227_Epic%20Games_860x1148-860x1148-b4c2210ee0c3c3b843a8de399bfe7f5c.jpg",
                "https://www.youtube.com/embed/BbLyNDOCUNE",
                "Red Dead Redemption 2 é um jogo de mundo aberto que se passa no velho oeste e desenvolvido e publicado pela Rockstar Games. É o terceiro título da série Red Dead e uma prequela de Red Dead Redemption.",
                "Rockstar Games",
                "Rockstar Games",
                new BigDecimal("200.0"),
                0.0,
                LocalDate.of(2018, 10, 26),
                100,
                catMundoAberto
        );
        this.gameRepository.save(game);

        game = new GameModel(
                "Dark Souls III",
                "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgcjxa_TGveXX60D32QuxiWOEiFfUnvhpHaH7RprB_BZ3dwlYjOGJttG5QRbcuRcI5B7bdoItlt_c50CDyJuzz9BKfbVCJX9ZY4V__Wk-FUM8wsv_5FVB43FuG9NyQyX-ciEWJYz9BUxBw/s1600/DSIII_2D_PS4_PEGI_1434385550.jpg",
                "https://www.youtube.com/embed/cWBwFhUv1-8",
                "DARK SOULS™ continua a ultrapassar seus próprios limites em um ambicioso novo capítulo da série que definiu um gênero e que é aclamada pela crítica. Prepare-se para abraçar a escuridão!",
                "FromSoftware",
                "Bandai Namco Entertainment",
                new BigDecimal("100.0"),
                0.0,
                LocalDate.of(2016, 3, 24),
                100,
                catSoulsLike
        );
        this.gameRepository.save(game);

        game = new GameModel(
                "Bloodborne",
                "https://image.api.playstation.com/vulcan/img/rnd/202010/2614/Sy5e8DmeKIJVjlAGraPAJYkT.png",
                "https://www.youtube.com/embed/G203e1HhixY",
                "Perigo, morte e loucura estão em cada canto deste sombrio e horroroso mundo, e você deve descobrir seus segredos mais sombrios para sobreviver. -Um aterrorizante mundo novo: Faça uma jornada para uma cidade gótica cheia de horror, onde multidões loucas e criaturas assustadoras espreitam em cada canto.",
                "FromSoftware",
                "Sony Interactive Entertainment",
                new BigDecimal("150.0"),
                0.0,
                LocalDate.of(2015, 3, 24),
                100,
                catSoulsLike
        );
        this.gameRepository.save(game);

        game = new GameModel(
                "Sekiro: Shadows Die Twice",
                "https://i.pinimg.com/736x/4c/b0/64/4cb06400217424f1da7f415f64b2ae34.jpg",
                "https://www.youtube.com/embed/rXMX4YJ7Lks",
                "Em Sekiro: Shadows Die Twice você é o 'lobo de um braço só', um guerreiro desfigurado e desgraçado resgatado da beira da morte. Destinado a proteger um jovem senhor descendente de uma antiga linhagem, você se tornará alvo de muitos inimigos cruéis, incluindo o perigoso clã Ashina.",
                "FromSoftware",
                "Activision",
                new BigDecimal("200.0"),
                0.0,
                LocalDate.of(2019, 3, 21),
                100,
                catSoulsLike
        );
        this.gameRepository.save(game);

        game = new GameModel(
                "Elden Ring",
                "https://m.media-amazon.com/images/I/6110RSDn3PL.jpg",
                "https://www.youtube.com/embed/K_03kFqWfqs",
                "Levante-se, Maculado, e seja guiado pela graça para portar o poder do Anel Prístino e se tornar um Lorde Prístino nas Terras Intermédias. Em Elden Ring, junte-se a um mundo cheio de mistérios e perigos, e embarque em uma jornada épica para desvendar o destino do Reino.",
                "FromSoftware",
                "Bandai Namco Entertainment",
                new BigDecimal("250.0"),
                0.0,
                LocalDate.of(2022, 2, 24),
                100,
                catSoulsLike
        );
        this.gameRepository.save(game);
    }
}
