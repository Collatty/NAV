# Kodeoppgave for NAV

### Spørsmål:

#### Hva er ditt favorittprogrammeringsspråk, og hvorfor?

Java, da det er dette jeg kan best. Ser dog ikke bort fra at det kan bli JavaScript når jeg har lært meg dette litt bedre, da jeg har blitt fortalt at så og si alt kan gjøres i JavaScript.

#### Hva er best av quicksort og bubblesort og hvorfor?

Kort oppsummert så er quicksort bedre da den mest sannsynlig sorterer elementene dine raskere enn bubblesort.

For nesten alle formål vil quicksort være bedre enn bubblesort. Bubblesort snitter på O(n^2) mens quicksort snitter på O(n*log(n)). Dersom en liste er tilnærmet sortert vil bubblesort kunne slå quicksort da best case er O(n), mens quicksort sin best case er O(n*log(n)).


#### Hva legger du i god kodekvalitet og er dette viktig?

I god kodekvalitet legger jeg at koden som skrives er lettleselig og oversiktlig. Både med tanke på filstrukturering og strukturerring innad i hver fil. Videre burde koden skrives slik at mest mulig kan gjenbrukes ved senere anledninger. Er det noe i koden som ikke er åpenbart, kommentér hva koden gjør. Navngi variabler, klasser metoder etc etter gjeldende konvensjoner for språket du skriver i.

Ja, spesielt på prosjekter hvor flere samarbeider om kodingen.


#### Hvorfor vil du jobbe i NAV?

Ordet på linjen er at dere er en sjult skatt. På utsiden fremstår ikke "NAV" som det heteste på tek-markedet, men ryktene skal ha det til at dere jobber med mye kul teknologi. Jeg gjorde litt research for å finne ut om det var noe hold i disse ryktene, og jeg kom da blant annet innom [denne](https://memu.no/innspill/livet-er-en-strom-av-hendelser/) artikelen. Litt mer søking brakte meg over dette sitatet:
> Derfor tar NAV grep for å bli mer data og innsiktsdrevet i møte med den enkelte bruker og i beslutningsprosesser. Vi har etablert en AI-lab med spydspisser innen bruk av maskinlæring. Vi etablerer et dataøkosystem, basert på Apache Kafka, som endrer hvordan vi utvikler applikasjoner. Vi etablerer, gjennom en teknologi-lab, en portefølje av teknologier for å gjøre etaten mer selvbetjent på data og innsikt.

Summen av dette var nok til å overbevise meg om å søke.

### Om koden

#### Kilder

Jeg har tatt utgangspunkt i informasjonen om fødselsnummer på [Wikipedia](https://no.wikipedia.org/wiki/F%C3%B8dselsnummer)
for å utvikle kravene mine til fødselsnummeret.

#### Teknologi

Backend:

 - Skrevet i Java med IntelliJ IDEA som utviklingverktøy.

 - Spring-boot som server.

 - Code coverage på 80-85% (5.10.2018).

Frontend:

 - [Bootstrappet](https://stackoverflow.com/questions/1254542/what-is-bootstrapping) med create-react-app.

 - Prøvet og feilet litt med materialize-css.

-----------------------------------------------------------------------------
Prosjektet serves fra min droplet hos Digital Ocean
