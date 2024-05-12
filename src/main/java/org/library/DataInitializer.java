package org.library;

import org.library.entities.Author;
import org.library.entities.Book;
import org.library.entities.Genre;
import org.library.repositories.AuthorRepository;
import org.library.repositories.BookRepository;
import org.library.repositories.GenreRepository;
import org.library.services.CustomerService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DataInitializer {

    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;
    private final BookRepository bookRepository;
    private final CustomerService customerService;

    public DataInitializer(AuthorRepository authorRepository, GenreRepository genreRepository, BookRepository bookRepository, CustomerService customerService) {
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
        this.bookRepository = bookRepository;
        this.customerService = customerService;
    }

    Genre scifi = new Genre("Science Fiction");
    Genre fantasy = new Genre("Fantasy");
    Genre horror = new Genre("Horror");
    Genre thriller = new Genre("Thriller");
    Genre powiesc = new Genre("Powieść");
    Genre powiescHistoryczna = new Genre("Powieść Historyczna");

    Author grzedowicz = new Author("Jarosław Grzędowicz", List.of(scifi, fantasy));
    Author pilipiuk = new Author("Andrzej Pilipiuk", List.of(scifi, fantasy, horror, thriller, powiesc));
    Author mroz = new Author("Remigiusz Mróz", List.of(scifi, powiescHistoryczna, horror));
    Author ziemianski = new Author("Andrzej Ziemiański", List.of(fantasy, powiescHistoryczna));
    Author kossakowska = new Author("Maja Lidia Kossakowska", List.of(fantasy, scifi, horror));
    Author piekara = new Author("Jacek Piekara", List.of(fantasy, horror, powiescHistoryczna));
    Author mortka = new Author("Marcin Mortka", List.of(powiescHistoryczna, fantasy));
    Author lem = new Author("Stanisław Lem", List.of(scifi, powiesc));
    Author sapkowski = new Author("Andrzej Sapkowski", List.of(fantasy));


    @EventListener(ApplicationReadyEvent.class)
    void save() {

        genreRepository.saveAll(List.of(scifi, fantasy, powiescHistoryczna, thriller, powiesc, horror));
        authorRepository.saveAll(List.of(grzedowicz, pilipiuk, mroz, ziemianski, kossakowska, piekara, mortka, lem, sapkowski));
        bookRepository.saveAll(generateBooks());
        saveCustomers();
    }

    private void saveCustomers() {
        customerService.saveCustomer("Jan", "Kowalski", "sdsdfsf4ff1");
        customerService.saveCustomer("Anna", "Nowak", "sdsdfsf4ff2");
        customerService.saveCustomer("Piotr", "Zieliński", "sdsdfsf4ff3");
        customerService.saveCustomer("Katarzyna", "Wójcik", "sdsdfsf4ff4");
        customerService.saveCustomer("Michał", "Szymański", "sdsdfsf4ff5");
        customerService.saveCustomer("Agnieszka", "Woźniak", "sdsdfsf4ff6");
        customerService.saveCustomer("Tomasz", "Kozłowski", "sdsdfsf4ff7");
        customerService.saveCustomer("Małgorzata", "Jankowski", "sdsdfsf4ff8");
        customerService.saveCustomer("Paweł", "Włodarczyk", "sdsdfsf4ff9");
        customerService.saveCustomer("Ewa", "Kwiatkowski", "sdsdfsf4ff10");
    }


    private List<Book> generateBooks() {
        return List.of(
                new Book("Pan lodowego Ogrodu tom 1", grzedowicz, LocalDate.of(2012, 11, 13), fantasy, " Majstersztyk literatury fantasy. Grzędowicz stworzył pełnokrwistych bohaterów i realistyczny świat. Wciągająca opowieść o Vuko Drakkainenie, który wyrusza na niebezpieczną misję"),
                new Book("Pan lodowego Ogrodu tom 2", grzedowicz, LocalDate.of(2012, 12, 24), fantasy, "Kontynuacja przygód Vuko, choć tempo akcji zwalnia. Świat wykreowany staje się mniej zaskakujący niż przy pierwszym spotkaniu"),
                new Book("Pan lodowego Ogrodu tom 3", grzedowicz, LocalDate.of(2013, 1, 1), fantasy, " Powrót do znanego świata z poprzednich części. Wciągająca opowieść, która nie wypuści czytelnika"),
                new Book("Pan lodowego Ogrodu tom 4", grzedowicz, LocalDate.of(2013, 2, 1), fantasy, " Zakończenie sagi, które zadowoli czytelników. Powraca atmosfera niesamowitej planety Midgaard, w której magia zmienia świat i ludzi. Wszystko zmierza tu do wielkiego finału, do rozwiązania problemów planety Midgaard1. Jest to nie tylko wysokiej jakości powieść fantasy, lecz również klasowe, pełne i udane zakończenie obszernego dzieła"),
                new Book("Hel 3: Ostatnie dni", grzedowicz, LocalDate.of(2014, 1, 1), scifi, "“Hel 3: Ostatnie dni” to książka, która skłania do refleksji nad konsekwencjami rozwoju technologicznego kosztem wolności jednostki1. Jest to ponura, dystopijna, możliwa do spełnienia wizja nadchodzącej przyszłości2. Główny bohater, Norbert, jest iwenciarskim reporterem, który dokumentuje świat rozwoju technologii i upadku człowieczeństwa. Książka może być trudniejsza w lekturze zarówno ze względu na styl, jak i treść"),
                new Book("Popiół i Snieg", grzedowicz, LocalDate.of(2015, 1, 1), fantasy, "Skłania do refleksji nad konsekwencjami rozwoju technologicznego kosztem wolności jednostki1. Jest to ponura, dystopijna, możliwa do spełnienia wizja nadchodzącej przyszłości2. Główny bohater, Norbert, jest iwenciarskim reporterem, który dokumentuje świat rozwoju technologii i upadku człowieczeństwa. Książka może być trudniejsza w lekturze zarówno ze względu na styl, jak i treść."),
                new Book("Wrota Niebios", grzedowicz, LocalDate.of(2016, 1, 1), fantasy, "Ta książka opowiada o sekcie, która łączy elementy chrześcijaństwa, science fiction i ufologii. Inspiracją dla członków były motywy z serialu telewizyjnego Star Trek. Organizacja, choć z pozoru nieszkodliwa, skrywa mroczne tajemnice, które stopniowo wychodzą na światło dzienne."),
                new Book("Kuzynki", pilipiuk, LocalDate.of(2003, 1, 1), fantasy, "Katarzyna Kruszewska trafia w czasie pracy dla CBŚ na ślad swojej kuzynki, która wróciła z Etiopii i pracuje w krakowskim liceum jako nauczycielka. Nie byłoby w tym nic dziwnego, gdyby nie to, że kuzynka urodziła się ponad 120 lat wcześniej! W tym samym czasie do Polski trafia uratowana na Bałkanach 16-letnia Monika Stiepankovic...."),
                new Book("Czarownik Iwanow", pilipiuk, LocalDate.of(2004, 1, 1), fantasy, "Jakub Wędrowycz jest jedną z najlepiej wykrojonych postaci polskiej fantasy. Opowiadania o wiejskim egzorcyście łączą wisielczy humor z nader precyzyjną obserwacją obyczajową. Ta ostatnia sprawia, że wszelkie potwory, demony i wampiry trapiące Jakuba Wędrowycza, są znacznie mniej przerażające niż podejrzenie, które ogarnia w pewnym momencie czytelnika - mianowicie, iż ów wiejski pejzaż krainy Wędrowycza nie jest jedynie fantazją. (Anna Brzezińska)"),
                new Book("Oko Jelenia tom 1", pilipiuk, LocalDate.of(2005, 1, 1), fantasy, "Zaczyna się jak u Hitchcocka. W dodatku nie od trzęsienia, lecz od całkowitej zagłady Ziemi. A potem napięcie wciąż rośnie. Występują: Kosmiczni Nomadzi, którzy rąbnęli 5 milionów książek razem z opakowaniem, czyli gmachem Biblioteki Narodowej, przypadkowi turyści przeniesieni w czasie, ze swoich światów wrzuceni na dno średniowiecznego slumsu: nauczyciel informatyki, nastolatek z Warszawy, szlachcianka spod XVIII-wiecznego Lublina. W Norwegii Anno Domini 1559 muszą przeżyć. I wypełnić misję - odnaleźć oko jelenia, wpierw ustaliwszy, co to, u diabła, jest!"),
                new Book("Oko Jelenia tom 2", pilipiuk, LocalDate.of(2006, 1, 1), fantasy, "Wyobraź sobie, że dziś znaczy przed wiekami, a doczekanie jutra graniczy z cudem... Norwegia A.D. 1559 to czasy zabójcze dla trojga współczesnych Ziemian. W dniu zagłady, ratując skórę, oddali się w niewolę mrocznego strażnika pamięci Kosmosu. Przed nimi straceńcza misja pod nadzorem bezwzględnego kapo, kombinacji futrzaka z maszyną. Swoją misję mają hanzeatyccy kupcy, których drogi krzyżują się ze ścieżkami naszych bohaterów. Bo \"Oko\" to nie tylko wielotomowa, ale też wielowątkowa i wielopiętrowa opowieść z widokiem na Wszechświat."),
                new Book("Oko Jelenia tom 3", pilipiuk, LocalDate.of(2007, 1, 1), fantasy, "Oto oni! Nauczyciel informatyki, nastolatek z Warszawy i szlachcianka spod XVIII-wiecznego Lublina. Znowu w akcji! Troje bohaterów z przypadku wrzuconych w wir zdarzeń na jednym z ramion wielkiego koła zamachowego historii. Dokładnie zaś do XVI-wiecznej Norwegii, która ponownie okazuje się miejscem bardzo niezdrowym do życia. Codziennie pachnie tu (no może lepiej powiedzieć, cuchnie) niebezpieczeństwem, ale i wielką przygodą. Istoty z różnych czasów i zakątków wszechświata wpadają na siebie w najmniej spodziewanych okolicznościach. Na dodatek bezwzględni agenci Hanzy nieustannie czyhają na życie naszych bohaterów."),
                new Book("Behawiorysta", mroz, LocalDate.of(2013, 1, 1), thriller, "Zamachowiec zajmuje przedszkole, grożąc że zabije wychowawców i dzieci. Policja jest bezsilna, a mężczyzna nie przedstawia żadnych żądań. Nikt nie wie, dlaczego wziął zakładników, ani co zamierza osiągnąć. Sytuację komplikuje fakt, że transmisja na żywo z przedszkola pojawia się w internecie."),
                new Book("Testament", mroz, LocalDate.of(2014, 1, 1), thriller, "Znany warszawski ginekolog niespodziewanie otrzymuje ogromny spadek od jednej ze swoich pacjentek, choć przyjął ją w gabinecie tylko raz. W skład masy spadkowej wchodzi zapuszczona nieruchomość, która lata temu po reprywatyzacji stała się własnością kobiety. Kiedy lekarz jedzie na miejsce, czeka go kolejne zaskoczenie – odnajduje zwłoki w stanie zaawansowanego rozkładu, a niedługo potem ginekologiem interesuje się policja, gotowa aresztować go za przestępstwo."),
                new Book("Zaginięcie", mroz, LocalDate.of(2015, 1, 1), thriller, "Trzyletnia dziewczynka znika bez śladu z domku letniskowego bogatych rodziców. Alarm przez całą noc był wyłączony, a okna i drzwi zamknięte. Śledczy nie odnajdują żadnych poszlak świadczących o porwaniu i podejrzewają, że dziecko nie żyje."),
                new Book("Oskarżenie", mroz, LocalDate.of(2016, 1, 1), thriller, "Od serii brutalnych morderstw pod Warszawą minęły cztery lata. Sprawcę ujęto, skazano, a potem osadzono w więzieniu. Dowody wskazujące na dawną legendę „Solidarności” były nie do podważenia."),
                new Book("Wyrok", mroz, LocalDate.of(2017, 1, 1), thriller, "Po zdanym egzaminie adwokackim, świeżo upieczony mecenas Oryński ma zastąpić Chyłkę jako główna siła napędowa kancelarii Żelazny & McVay. Pierwsza sprawa, jaką poprowadzi, niechybnie zaważy na całej jego przyszłości zawodowej. Kordian nie ma jednak żadnego wyboru – zostaje zmuszony przez Piotra Langera, by podjąć się obrony pewnego chłopaka w Poznaniu. Co ich łączy? I dlaczego Langerowi tak zależy na jego obronie?"),
                new Book("Achaja. Tom I", ziemianski, LocalDate.of(2002, 1, 1), fantasy, "Ale jeśli pójdziesz przeciwko stu i powiesz sobie: „Ja wybrałam! Wiem, że to śmierć, wiem, że to zatracenie, ale robię to dla siebie\". Wtedy w walce jest wolność. Tylko nie patrz na innych. Zobacz samą siebie we własnych oczach. Nigdy nie patrz na innych. Wolność to ty, kotku. Tylko ty!"),
                new Book("Achaja. Tom II", ziemianski, LocalDate.of(2003, 1, 1), fantasy, "\"Bogowie! Przecież teraz...sama była potworem. Naprawdę nie była już przerażoną dziewczynką. To ona mogłaby straszyć małe dziewczynki.\""),
                new Book("Achaja. Tom III", ziemianski, LocalDate.of(2004, 1, 1), fantasy, "Achaja - księżniczka, która sięgnęła dna, złamana niewolnica, honorowy żołnierz, potwór o złotym sercu."),
                new Book("Pomnik cesarzowej Achai. Tom I", ziemianski, LocalDate.of(2012, 1, 1), fantasy, "Pomnik cesarzowej Achai był tak duży, że wyrastał nawet nad okoliczne skały. Kai skrzywiła się patrząc na wykute w kamieniu wyobrażenie dziewczyny sprzed paruset lat. Miała dziwną twarz o wyrazie arogancji i pewności siebie, patrzyła gdzieś w przestrzeń, ponad piaskami pustyni otaczającymi szkołę czarowników."),
                new Book("Pomnik cesarzowej Achai. Tom II", ziemianski, LocalDate.of(2013, 1, 1), fantasy, "Pomnik cesarzowej jest potężny i wzbudza strach. Nadchodzi czas silnych kobiet i równoległych światów. Ziemiański jak nikt inny zderza dwie odległe cywilizacje i systemy wojskowe. Wie o tym każdy fan kultowej „Achai” i niemal pół miliona czytelników książek Andrzeja Ziemiańskiego."),
                new Book("Siewca Wiatru", kossakowska, LocalDate.of(2004, 1, 1), fantasy, "Bóg umarł - stwierdził filozof. A może odszedł? - zapytała pisarka. I postawiła BezPańskie anielskie zastępy w obliczu Armagedonu. Jej anioły są niepokojąco ludzkie. Palą, piją, piorą się po pyskach, bywają w burdelach, mają niewyparzone gęby, cierpią „na samotność”, są po naszemu pazerne."),
                new Book("Żarna niebios", kossakowska, LocalDate.of(2008, 1, 1), fantasy, "Aniołowie paktują z diabłami. Grzeszą pychą. Piją, bywają w burdelach i kasynach. Knują, zabijają, umierają. Z niebiańskiej doskonałości pozostał im tylko doskonały wygląd."),
                new Book("Zbieracz Burz. Tom I", kossakowska, LocalDate.of(2010, 1, 1), fantasy, "Oto on... Niszczyciel Światów, Miecz Pana, Lewa Ręka Boga. Oto Królestwo Niebieskie... w którym nie ma Boga."),
                new Book("Zbieracz Burz. Tom II", kossakowska, LocalDate.of(2010, 1, 1), fantasy, "Oto on... Niszczyciel Światów, Miecz Pana, Lewa Ręka Boga. Oto Królestwo Niebieskie... w którym nie ma Boga. Oto miejsce, gdzie archanioł sprzymierza się z diabłem. Oto Daimon Frey. Wiara, Nadzieja, Miłość... To jego grzechy kardynalne. Nad jego głową znów zawisły ciężkie chmury, a w Siódmym Niebie zaległa głucha cisza... cisza przed burzą."),
                new Book("Zakon Krańca Świata. Tom I", kossakowska, LocalDate.of(2005, 1, 1), fantasy, "Nadszedł Koniec Świata. A właściwie dwanaście Końców- każdemu wierzącemu według potrzeb. Były katastrofy ekologiczne i naturalne, wojna atomowa, atak kosmitów, zstąpienie Jeźdźców i wiele innych wersji Apokalipsy. Nieliczni sprawiedliwi szczęśliwcy trafili do swoich Rajów. Reszta ludzkości zdana jest sama na siebie i walczy o przetrwanie w świecie przepełnionym chaosem."),
                new Book("Ja, Inkwizytor. Sługa Boży", piekara, LocalDate.of(2003, 1, 1), fantasy, "Oto on – inkwizytor i sługa boży. Człowiek głębokiej wiary."),
                new Book("Ja, Inkwizytor. Młot na Czarownice", piekara, LocalDate.of(2003, 1, 1), fantasy, "Minęło tysiąc pięćset lat, od kiedy Jezus zszedł z krzyża, utopił we krwi Jerozolimę i zdobył Rzym. Światem rządzą inkwizytorzy."),
                new Book("Ja, Inkwizytor. Miecz Aniołów", piekara, LocalDate.of(2004, 1, 1), fantasy, "Jeżeli zadajesz sobie pytania, strzeż się, gdyż możesz usłyszeć odpowiedź – mówi stare porzekadło. Inkwizytor Mordimer Madderdin nie waha się zadawać pytań i dążyć do odkrywania prawdy o świecie, który go otacza. Świecie pełnym intryg i zła. Świecie, w którym ludziom zagrażają demony, czarownicy oraz wyznawcy mrocznych kultów. Świecie, którego siłą napędową są nienawiść, chciwość oraz żądza."),
                new Book("Ja, Inkwizytor. Łowcy Dusz", piekara, LocalDate.of(2006, 1, 1), fantasy, "Mordimer Madderdin, inkwizytor Jego Ekscelencji biskupa Hez-hezronu, pozna największy sekret chrześcijańskiej wiary. Jednak przedtem los powiedzie go do cesarskiej stolicy, gdzie trafi w sam środek politycznych intryg. Odwiedzi zamek magnata oskarżonego o odprawianie demonicznych rytuałów i weźmie udział w krucjacie Najjaśniejszego Pana przeciw heretykom. Spotka dziewczynę z wytatuowanym znakiem Węża i Gołębicy i odprowadzi ją na dwór barona – wampira, który półtora tysiąca lat wcześniej był świadkiem ukrzyżowania Jezusa."),
                new Book("Ja, Inkwizytor. Wieże do Nieba", piekara, LocalDate.of(2010, 1, 1), fantasy, "Piękne dziewczęta giną z ręki okrutnego seryjnego zabójcy. Rozwikłania tajemnicy morderstw podejmuje się mistrz Knotte. Starego i doświadczonego inkwizytora wspomaga serdecznie go nienawidzący Mordimer Madderdin."),
                new Book("Nie ma tego Złego (Drużyna do zadań specjalnych, #1)", mortka, LocalDate.of(2021, 1, 1), fantasy, "Edmund zwany Kociołkiem, niegdyś żołnierz w armii księcia Stefana, dziś spełniony mąż i ojciec, a do tego karczmarz słynny na całe Wichrowiny, wdepnął w bagno, które podejrzanie zalatuje Złem. Razem ze swą drużyną do zadań specjalnych – socjopatycznym elfem, goblinem zwiadowcą, pełnym tajemnic guślarzem, charakternym krasnoludem i jednym z ostatnich prawdziwych rycerzy Doli – otrzymał zlecenie, które okazało się czymś więcej niż zwykłe dostarczanie przesyłek czy osłanianie karawan."),
                new Book("Głodna Puszcza (Drużyna do zadań specjalnych, #2)", mortka, LocalDate.of(2021, 1, 1), fantasy, "Do karczmy Edmunda zwanego Kociołkiem potajemnie zjeżdżają książęta, by radzić nad przyszłością Doliny. Ostatnio trolle z Głodnej Puszczy wydają się nad wyraz aktywne, a jedyny człowiek, który umie z nimi gadać – rycerz Pogorzałek – gdzieś w owej puszczy zaginął. Kociołek nie ma najmniejszej ochoty, by służyć możnym (i zadufanym) tego świata, ale okazuje się, że istnieje niezawodny sposób, by skłonić go do kolejnych bohaterskich czynów. Tylko czy upora się z zadaniem do niedzieli, jak obiecał żonie?"),
                new Book("Przed wyruszeniem w drogę (Drużyna do zadań specjalnych, #0)", mortka, LocalDate.of(2022, 1, 1), fantasy, "Czy zastanawialiście się może, co krasnolud Gramm właściwie robi wśród ludzi? Albo w jakich okolicznościach Kociołek poznał Żychłonia? Co podczas Waśni robił Urgo? Skąd się wzięło imię Eliah? Czy Zwierzak umie się na kogoś obrazić?"),
                new Book("Skrzynia pełna dusz (Drużyna do zadań specjalnych, #3)", mortka, LocalDate.of(2022, 1, 1), fantasy, "W Dolinie rozhulały się jesienne wichry, co z reguły jest złym znakiem – nie dość, że zimno, to jeszcze nie wiadomo, co przywieją. Edmunda zwanego Kociołkiem, gospodarza w karczmie Pod Kaprawym Gryfem, martwi głównie to drugie, bo wrogów sobie w świecie narobił niemało. I choć jeszcze tego nie wie, do jego gospody zmierza właśnie pewna banda z Głodnej Puszczy. A za nią kolejna, jeszcze większa. "),
                new Book("Mroźny szlak (Straceńcy Madsa Voortena, #1)", mortka, LocalDate.of(2022, 1, 1), fantasy, "W czasie, gdy ciemiężone od stulecia narody Rozkrzyczanych Krain chwyciły za broń i wydały wojnę swym oprawcom, Mads Voorten, daleko od linii frontu, przemierza mroźne guchoborskie góry. Uwikłany w krasnoludzką intrygę, zmaga się z niebezpieczeństwami, by przyjść z pomocą swej kompanii, do której należą między innymi niewidomy uzdrowiciel, zagubiony w ludzkim świecie elf i prostoduszny telepata. Równolegle musi sobie poukładać stosunki z niezmiernie osobliwą smoczycą."),
                new Book("Solaris", lem, LocalDate.of(1961, 1, 1), scifi, "W Solaris Stanisław Lem podejmuje jeden z najpopularniejszych tematów literatury fantastycznej - temat Kontaktu. Z obcą cywilizacją, odmienną formą życia, a może po prostu z Nieznanym, tego Lem jednoznacznie nie dopowiada. Być może dlatego Solaris po kilkudziesięciu lat od pierwszego wydania wciąż fascynuje."),
                new Book("Kongres futurologiczny", lem, LocalDate.of(1971, 1, 1), scifi, "\"Kongres futurologiczny\", którego narratorem i bohaterem jest znany doskonale czytelnikom Lema — choćby z \"Wizji lokalnej\", \"Pokoju na Ziemi\" i \"Dzienników gwiazdowych\" — Ijon Tichy, przedstawia antyutopijną wizję społeczeństwa przyszłości. Futurologiczny koszmar ukazany został w obrazie świata, którego materialną i duchową nędzę maskują halucynacje wywołane działaniem środków chemicznych. Środki te, rozpylone w powietrzu, sprawiają, że postrzegana \"rzeczywistość\" jawi się mieszkańcom owego świata w postaci sielankowych projekcji ich marzeń i pragnień. Lem posłużył się tu po mistrzowsku alegorycznym chwytem, którego sens — po dwudziestowiecznych doświadczeniach totalitarnej propagandy i masowych eksperymentów socjotechnicznych — nie wymaga szczególnych objaśnień."),
                new Book("Cyberiada", lem, LocalDate.of(1965, 1, 1), scifi, "\"Cyberiada\" to książka, którą Lem lubi - i uważa za swój prywatny wkład w poetykę literatury science fiction. W samej rzeczy nikt bodaj przedtem nie skrzyżował w taki sposób przyszłościowej fantastyki z baśnią i filozoficzną powiastką, nikt też nie sporządził takiego stopu materii \"naukowo-technicznej\" z baśniowym sztafażem przedstawionego świata. "),
                new Book("Niezwyciężony", lem, LocalDate.of(1964, 1, 1), scifi, "Powieść \"Niezwyciężony\" zajmuje szczególne miejsce w dorobku Stanisława Lema. Z kilku powodów. Przede wszystkim jest to batalistyczna space opera – opowieść o starciu ludzi z powstałą samorzutnie na odległej planecie populacją mikroautomatów niszczących wszelkie myślenie."),
                new Book("Dzienniki gwiazdowe", lem, LocalDate.of(1971, 1, 1), scifi, "Czego możemy się nauczyć od kosmitów? W cyklu opowiadań pisanych przez ponad trzydzieści lat Stanisław Lem udowadnia, że bardzo wiele."),
                new Book("Ostatnie życzenie", sapkowski, LocalDate.of(1993, 1, 1), fantasy, "Później mówiono, że człowiek ów nadszedł od północy, od Bramy Powroźniczej. Nie był stary, ale włosy miał zupełnie białe. Kiedy ściągnął płaszcz, okazało się, że na pasie za plecami ma miecz."),
                new Book("Miecz Przeznaczenia", sapkowski, LocalDate.of(1992, 1, 1), fantasy, "Wiedźmiński kodeks stawia tę sprawę w sposób jednoznaczny: wiedźminowi smoka zabijać się nie godzi."),
                new Book("Krew elfów", sapkowski, LocalDate.of(1994, 1, 1), fantasy, "Andrzej Sapkowski, arcymistrz światowej fantasy, zaprasza do swojego Neverlandu i przedstawia uwielbianą przez czytelników i wychwalaną przez krytykę wiedźmińską sagę!"),
                new Book("Czas pogardy", sapkowski, LocalDate.of(1995, 1, 1), fantasy, "Świat Ciri i wiedźmina ogarniają płomienie. Nastał zapowiadany przez Ithlinne czas miecza i topora."),
                new Book("Chrzest ognia", sapkowski, LocalDate.of(1996, 1, 1), fantasy, "Oto Geraltowa kompania: JASKIER, trubadur w kapelusiku z piórkiem egreta. Studiował siedem sztuk wyzwolonych, słynny po wszystkich dworach i zamtuzach. „Kłamliwa łajza” i „zachrypnięty bażant” to najłagodniejsze z określeń, jakim obdarzają go porzucone kochanki. CAHIR, czarny rycerz z koszmarów Ciri. Poszukiwany przez najlepszych szpiegów Cesarstwa Nilfgaardczyk, który dowodzi, że Nilfgaardczykiem wcale nie jest. MILVA, trafiająca z dwustu kroków łuczniczka. Pyskata i do słów nieparlamentarnych skora. REGIS, cyrulik intelektualista. Nosi się staroświecko i pachnie ziołowo-korzennie Osobnik jakby nie z tej bajki. Piątka krasnoludów oraz sprytny gnom zwiadowca.")
        );
    }


}
