package workday;

import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;

public enum WorkdayTimeZone {
    /*
     * Provides enumeration for XpressoTimeZones and internal time zone string.
     * The internal time zone string values of enum will be stored in the database
     * as part of the attribute DateTimeZoneAttibute value
     *
     *  ********************************************************************************************
     *  * enumeration values should not be deleted. Internal time zone string values should not be changed.
     *  * If Internal time zone string values need to be change or delete a conversion will need to
     *  * be written for any existing DateTimeZone Attributes that use this internal timezone id
     *  ********************************************************************************************
     */
    DatelineTimeMarshallIslands("TZ001", "Etc/GMT+12"),
    SamoaTimeSamoa("TZ002", "Pacific/Midway"),
    HawaiiTimeHonolulu("TZ003", "Pacific/Honolulu"),
    AlaskaTimeAnchorage("TZ004", "US/Alaska"),
    PacificTimeSanFrancisco("TZ005", "US/Pacific"),
    MexicoPacificTimeTijuana("TZ006", "Mexico/BajaNorte"),
    MountainTimeDenver("TZ007", "US/Mountain"),
    MountainTimeArizona("TZ008", "US/Arizona"),
    MexicoMountainTimeChihuahua("TZ009", "Mexico/BajaSur"),
    CentralTimeChicago("TZ010", "US/Central"),
    CentralTimeSaskatchewan("TZ011", "Canada/Saskatchewan"),
    MexicoCentralTimeMexicoCity("TZ012", "Mexico/General"),
    AmericaPacificTimeBogota("TZ013", "America/Bogota"),
    EasternTimeNewYork("TZ014", "US/Eastern"),
    EasternTimeIndiana("TZ015", "US/East-Indiana"),
    AmericaWesternTimeCaracas("TZ016", "America/Caracas"),
    AtlanticTimeHalifax("TZ017", "America/Halifax"),
    AmericaWesternTimeLaPaz("TZ018", "America/La_Paz"),
    NewfoundlandTimeNewfoundland("TZ019", "Canada/Newfoundland"),
    SAmericaEasternTimeBuenosAires("TZ020", "America/Argentina/Buenos_Aires"),
    SAmericaEasternTimeBrasilia("TZ021", "America/Recife"),
    MidAtlanticTimeMidAtlantic("TZ022", "Atlantic/South_Georgia"),
    AzoresTimeAzores("TZ023", "Atlantic/Azores"),
    WesternEuropeanTimeCasablanca("TZ024", "Africa/Casablanca"),
    WesternEuropeanTimeLondon("TZ025", "Europe/London"),
    CentralEuropeanTimeAmsterdam("TZ026", "Europe/Amsterdam"),
    CentralEuropeanTimeBerlin("TZ027", "Europe/Berlin"),
    CentralEuropeanTimeOslo("TZ028", "Europe/Oslo"),
    CentralEuropeanTimeParis("TZ029", "Europe/Paris"),
    CentralEuropeanTimePrague("TZ030", "Europe/Prague"),
    CentralEuropeanTimeStockholm("TZ031", "Europe/Stockholm"),
    SouthAfricaTimePretoria("TZ032", "Africa/Johannesburg"),
    EasternEuropeanTimeCairo("TZ033", "Egypt"),
    EasternEuropeanTimeAthens("TZ034", "Europe/Athens"),
    EasternEuropeTimeBucharest("TZ035", "Europe/Bucharest"),
    EasternEuropeanTimeHelsinki("TZ036", "Europe/Helsinki"),
    IsraelTimeTelAviv("TZ037", "Israel"),
    EastAfricaTimeNairobi("TZ038", "Africa/Nairobi"),
    ArabianTimeRiyadh("TZ039", "Asia/Riyadh"),
    MoscowTimeMoscow("TZ040", "Europe/Moscow"),
    IranTimeTehran("TZ041", "Asia/Tehran"),
    ArabianTimeAbuDhabi("TZ042", "Asia/Muscat"),
    AfghanistanTimeKabul("TZ043", "Asia/Kabul"),
    AzerbaijanTimeBaku("TZ044", "Asia/Baku"),
    WestAsiaTimeEkaterinburg("TZ045", "Asia/Yekaterinburg"),
    WestAsiaTimeIslamabad("TZ046", "PLT"),
    SriLankaTimeColombo("TZ047", "Asia/Colombo"),
    IndiaTimeBombay("TZ048", "IST"),
    CentralAsiaTimeAlmaty("TZ049", "Asia/Almaty"),
    ThailandTimeBangkok("TZ050", "Asia/Bangkok"),
    MalaysianTimeKualaLumpur("TZ051", "Asia/Kuala_Lumpur"),
    SingaporeTimeSingapore("TZ052", "Asia/Singapore"),
    ChinaTimeTaipei("TZ053", "Asia/Taipei"),
    AustraliaWesternTimePerth("TZ054", "Australia/Perth"),
    ChinaTimeBeijing("TZ055", "CTT"),
    YakutskTimeYakutsk("TZ056", "Asia/Yakutsk"),
    JapanTimeTokyo("TZ057", "JST"),
    AustraliaCentralTimeAdelaide("TZ058", "Australia/Adelaide"),
    AustraliaCentralTimeDarwin("TZ059", "Australia/Darwin"),
    AustraliaEasternTimeBrisbane("TZ060", "Australia/Brisbane"),
    TasmaniaTimeHobart("TZ061", "Australia/Hobart"),
    AustraliaEasternTimeSydney("TZ062", "Australia/Sydney"),
    ChamorroTimeGuam("TZ063", "Pacific/Guam"),
    VladivostokTimeVladivostok("TZ064", "Etc/GMT-11"),
    CentralPacificTimeSolomonIs("TZ065", "Pacific/Guadalcanal"),
    NewZealandTimeWellington("TZ066", "Pacific/Auckland"),
    FijiTimeFiji("TZ067", "Pacific/Fiji"),
    PhilippinesTimeManila("TZ068", "Asia/Manila"),
    HongKongTime("TZ069", "Asia/Hong_Kong"),
    IndochinaTimeHoChiMinh("TZ070", "Asia/Ho_Chi_Minh"),
    WestIndonesiaTimeJakarta("TZ071", "Asia/Jakarta"),
    GulfStandardTimeDubai("TZ072", "Asia/Dubai"),
    CentralAfricaTimeHarare("TZ073", "Africa/Harare"),
    WestAfricaTimeLagos("TZ074", "Africa/Lagos"),
    KoreaStandardTimeSeoul("TZ075", "Asia/Seoul"),
    ACT("TZ076", "ACT"),
    AET("TZ077", "AET"),
    AGT("TZ078", "AGT"),
    ART("TZ079", "ART"),
    AST("TZ080", "AST"),
    AfricaAbidjan("TZ081", "Africa/Abidjan"),
    AfricaAccra("TZ082", "Africa/Accra"),
    AfricaAddisAbaba("TZ083", "Africa/Addis_Ababa"),
    AfricaAlgiers("TZ084", "Africa/Algiers"),
    AfricaAsmara("TZ085", "Africa/Asmara"),
    AfricaAsmera("TZ086", "Africa/Asmera"),
    AfricaBamako("TZ087", "Africa/Bamako"),
    AfricaBangui("TZ088", "Africa/Bangui"),
    AfricaBanjul("TZ089", "Africa/Banjul"),
    AfricaBissau("TZ090", "Africa/Bissau"),
    AfricaBlantyre("TZ091", "Africa/Blantyre"),
    AfricaBrazzaville("TZ092", "Africa/Brazzaville"),
    AfricaBujumbura("TZ093", "Africa/Bujumbura"),
    AfricaCairo("TZ094", "Africa/Cairo"),
    AfricaCeuta("TZ095", "Africa/Ceuta"),
    AfricaConakry("TZ096", "Africa/Conakry"),
    AfricaDakar("TZ097", "Africa/Dakar"),
    AfricaDaresSalaam("TZ098", "Africa/Dar_es_Salaam"),
    AfricaDjibouti("TZ099", "Africa/Djibouti"),
    AfricaDouala("TZ100", "Africa/Douala"),
    AfricaElAaiun("TZ101", "Africa/El_Aaiun"),
    AfricaFreetown("TZ102", "Africa/Freetown"),
    AfricaGaborone("TZ103", "Africa/Gaborone"),
    AfricaJuba("TZ104", "Africa/Juba"),
    AfricaKampala("TZ105", "Africa/Kampala"),
    AfricaKhartoum("TZ106", "Africa/Khartoum"),
    AfricaKigali("TZ107", "Africa/Kigali"),
    AfricaKinshasa("TZ108", "Africa/Kinshasa"),
    AfricaLibreville("TZ109", "Africa/Libreville"),
    AfricaLome("TZ110", "Africa/Lome"),
    AfricaLuanda("TZ111", "Africa/Luanda"),
    AfricaLubumbashi("TZ112", "Africa/Lubumbashi"),
    AfricaLusaka("TZ113", "Africa/Lusaka"),
    AfricaMalabo("TZ114", "Africa/Malabo"),
    AfricaMaputo("TZ115", "Africa/Maputo"),
    AfricaMaseru("TZ116", "Africa/Maseru"),
    AfricaMbabane("TZ117", "Africa/Mbabane"),
    AfricaMogadishu("TZ118", "Africa/Mogadishu"),
    AfricaMonrovia("TZ119", "Africa/Monrovia"),
    AfricaNdjamena("TZ120", "Africa/Ndjamena"),
    AfricaNiamey("TZ121", "Africa/Niamey"),
    AfricaNouakchott("TZ122", "Africa/Nouakchott"),
    AfricaOuagadougou("TZ123", "Africa/Ouagadougou"),
    AfricaPortoNovo("TZ124", "Africa/Porto-Novo"),
    AfricaSaoTome("TZ125", "Africa/Sao_Tome"),
    AfricaTimbuktu("TZ126", "Africa/Timbuktu"),
    AfricaTripoli("TZ127", "Africa/Tripoli"),
    AfricaTunis("TZ128", "Africa/Tunis"),
    AfricaWindhoek("TZ129", "Africa/Windhoek"),
    AmericaAdak("TZ130", "America/Adak"),
    AmericaAnchorage("TZ131", "America/Anchorage"),
    AmericaAnguilla("TZ132", "America/Anguilla"),
    AmericaAntigua("TZ133", "America/Antigua"),
    AmericaAraguaina("TZ134", "America/Araguaina"),
    AmericaArgentinaCatamarca("TZ135", "America/Argentina/Catamarca"),
    AmericaArgentinaComodRivadavia("TZ136", "America/Argentina/ComodRivadavia"),
    AmericaArgentinaCordoba("TZ137", "America/Argentina/Cordoba"),
    AmericaArgentinaJujuy("TZ138", "America/Argentina/Jujuy"),
    AmericaArgentinaLaRioja("TZ139", "America/Argentina/La_Rioja"),
    AmericaArgentinaMendoza("TZ140", "America/Argentina/Mendoza"),
    AmericaArgentinaRioGallegos("TZ141", "America/Argentina/Rio_Gallegos"),
    AmericaArgentinaSalta("TZ142", "America/Argentina/Salta"),
    AmericaArgentinaSanJuan("TZ143", "America/Argentina/San_Juan"),
    AmericaArgentinaSanLuis("TZ144", "America/Argentina/San_Luis"),
    AmericaArgentinaTucuman("TZ145", "America/Argentina/Tucuman"),
    AmericaArgentinaUshuaia("TZ146", "America/Argentina/Ushuaia"),
    AmericaAruba("TZ147", "America/Aruba"),
    AmericaAsuncion("TZ148", "America/Asuncion"),
    AmericaAtikokan("TZ149", "America/Atikokan"),
    AmericaAtka("TZ150", "America/Atka"),
    AmericaBahia("TZ151", "America/Bahia"),
    AmericaBahiaBanderas("TZ152", "America/Bahia_Banderas"),
    AmericaBarbados("TZ153", "America/Barbados"),
    AmericaBelem("TZ154", "America/Belem"),
    AmericaBelize("TZ155", "America/Belize"),
    AmericaBlancSablon("TZ156", "America/Blanc-Sablon"),
    AmericaBoaVista("TZ157", "America/Boa_Vista"),
    AmericaBoise("TZ158", "America/Boise"),
    AmericaBuenosAires("TZ159", "America/Buenos_Aires"),
    AmericaCambridgeBay("TZ160", "America/Cambridge_Bay"),
    AmericaCampoGrande("TZ161", "America/Campo_Grande"),
    AmericaCancun("TZ162", "America/Cancun"),
    AmericaCatamarca("TZ163", "America/Catamarca"),
    AmericaCayenne("TZ164", "America/Cayenne"),
    AmericaCayman("TZ165", "America/Cayman"),
    AmericaChicago("TZ166", "America/Chicago"),
    AmericaChihuahua("TZ167", "America/Chihuahua"),
    AmericaCoralHarbour("TZ168", "America/Coral_Harbour"),
    AmericaCordoba("TZ169", "America/Cordoba"),
    AmericaCostaRica("TZ170", "America/Costa_Rica"),
    AmericaCreston("TZ171", "America/Creston"),
    AmericaCuiaba("TZ172", "America/Cuiaba"),
    AmericaCuracao("TZ173", "America/Curacao"),
    AmericaDanmarkshavn("TZ174", "America/Danmarkshavn"),
    AmericaDawson("TZ175", "America/Dawson"),
    AmericaDawsonCreek("TZ176", "America/Dawson_Creek"),
    AmericaDenver("TZ177", "America/Denver"),
    AmericaDetroit("TZ178", "America/Detroit"),
    AmericaDominica("TZ179", "America/Dominica"),
    AmericaEdmonton("TZ180", "America/Edmonton"),
    AmericaEirunepe("TZ181", "America/Eirunepe"),
    AmericaElSalvador("TZ182", "America/El_Salvador"),
    AmericaEnsenada("TZ183", "America/Ensenada"),
    AmericaFortWayne("TZ184", "America/Fort_Wayne"),
    AmericaFortaleza("TZ185", "America/Fortaleza"),
    AmericaGlaceBay("TZ186", "America/Glace_Bay"),
    AmericaGodthab("TZ187", "America/Godthab"),
    AmericaGooseBay("TZ188", "America/Goose_Bay"),
    AmericaGrandTurk("TZ189", "America/Grand_Turk"),
    AmericaGrenada("TZ190", "America/Grenada"),
    AmericaGuadeloupe("TZ191", "America/Guadeloupe"),
    AmericaGuatemala("TZ192", "America/Guatemala"),
    AmericaGuayaquil("TZ193", "America/Guayaquil"),
    AmericaGuyana("TZ194", "America/Guyana"),
    AmericaHavana("TZ195", "America/Havana"),
    AmericaHermosillo("TZ196", "America/Hermosillo"),
    AmericaIndianaIndianapolis("TZ197", "America/Indiana/Indianapolis"),
    AmericaIndianaKnox("TZ198", "America/Indiana/Knox"),
    AmericaIndianaMarengo("TZ199", "America/Indiana/Marengo"),
    AmericaIndianaPetersburg("TZ200", "America/Indiana/Petersburg"),
    AmericaIndianaTellCity("TZ201", "America/Indiana/Tell_City"),
    AmericaIndianaVevay("TZ202", "America/Indiana/Vevay"),
    AmericaIndianaVincennes("TZ203", "America/Indiana/Vincennes"),
    AmericaIndianaWinamac("TZ204", "America/Indiana/Winamac"),
    AmericaIndianapolis("TZ205", "America/Indianapolis"),
    AmericaInuvik("TZ206", "America/Inuvik"),
    AmericaIqaluit("TZ207", "America/Iqaluit"),
    AmericaJamaica("TZ208", "America/Jamaica"),
    AmericaJujuy("TZ209", "America/Jujuy"),
    AmericaJuneau("TZ210", "America/Juneau"),
    AmericaKentuckyLouisville("TZ211", "America/Kentucky/Louisville"),
    AmericaKentuckyMonticello("TZ212", "America/Kentucky/Monticello"),
    AmericaKnoxIN("TZ213", "America/Knox_IN"),
    AmericaKralendijk("TZ214", "America/Kralendijk"),
    AmericaLima("TZ215", "America/Lima"),
    AmericaLosAngeles("TZ216", "America/Los_Angeles"),
    AmericaLouisville("TZ217", "America/Louisville"),
    AmericaLowerPrinces("TZ218", "America/Lower_Princes"),
    AmericaMaceio("TZ219", "America/Maceio"),
    AmericaManagua("TZ220", "America/Managua"),
    AmericaManaus("TZ221", "America/Manaus"),
    AmericaMarigot("TZ222", "America/Marigot"),
    AmericaMartinique("TZ223", "America/Martinique"),
    AmericaMatamoros("TZ224", "America/Matamoros"),
    AmericaMazatlan("TZ225", "America/Mazatlan"),
    AmericaMendoza("TZ226", "America/Mendoza"),
    AmericaMenominee("TZ227", "America/Menominee"),
    AmericaMerida("TZ228", "America/Merida"),
    AmericaMetlakatla("TZ229", "America/Metlakatla"),
    AmericaMexicoCity("TZ230", "America/Mexico_City"),
    AmericaMiquelon("TZ231", "America/Miquelon"),
    AmericaMoncton("TZ232", "America/Moncton"),
    AmericaMonterrey("TZ233", "America/Monterrey"),
    AmericaMontevideo("TZ234", "America/Montevideo"),
    AmericaMontreal("TZ235", "America/Montreal"),
    AmericaMontserrat("TZ236", "America/Montserrat"),
    AmericaNassau("TZ237", "America/Nassau"),
    AmericaNewYork("TZ238", "America/New_York"),
    AmericaNipigon("TZ239", "America/Nipigon"),
    AmericaNome("TZ240", "America/Nome"),
    AmericaNoronha("TZ241", "America/Noronha"),
    AmericaNorthDakotaBeulah("TZ242", "America/North_Dakota/Beulah"),
    AmericaNorthDakotaCenter("TZ243", "America/North_Dakota/Center"),
    AmericaNorthDakotaNewSalem("TZ244", "America/North_Dakota/New_Salem"),
    AmericaOjinaga("TZ245", "America/Ojinaga"),
    AmericaPanama("TZ246", "America/Panama"),
    AmericaPangnirtung("TZ247", "America/Pangnirtung"),
    AmericaParamaribo("TZ248", "America/Paramaribo"),
    AmericaPhoenix("TZ249", "America/Phoenix"),
    AmericaPortauPrince("TZ250", "America/Port-au-Prince"),
    AmericaPortofSpain("TZ251", "America/Port_of_Spain"),
    AmericaPortoAcre("TZ252", "America/Porto_Acre"),
    AmericaPortoVelho("TZ253", "America/Porto_Velho"),
    AmericaPuertoRico("TZ254", "America/Puerto_Rico"),
    AmericaRainyRiver("TZ255", "America/Rainy_River"),
    AmericaRankinInlet("TZ256", "America/Rankin_Inlet"),
    AmericaRegina("TZ257", "America/Regina"),
    AmericaResolute("TZ258", "America/Resolute"),
    AmericaRioBranco("TZ259", "America/Rio_Branco"),
    AmericaRosario("TZ260", "America/Rosario"),
    AmericaSantaIsabel("TZ261", "America/Santa_Isabel"),
    AmericaSantarem("TZ262", "America/Santarem"),
    AmericaSantiago("TZ263", "America/Santiago"),
    AmericaSantoDomingo("TZ264", "America/Santo_Domingo"),
    AmericaSaoPaulo("TZ265", "America/Sao_Paulo"),
    AmericaScoresbysund("TZ266", "America/Scoresbysund"),
    AmericaShiprock("TZ267", "America/Shiprock"),
    AmericaSitka("TZ268", "America/Sitka"),
    AmericaStBarthelemy("TZ269", "America/St_Barthelemy"),
    AmericaStJohns("TZ270", "America/St_Johns"),
    AmericaStKitts("TZ271", "America/St_Kitts"),
    AmericaStLucia("TZ272", "America/St_Lucia"),
    AmericaStThomas("TZ273", "America/St_Thomas"),
    AmericaStVincent("TZ274", "America/St_Vincent"),
    AmericaSwiftCurrent("TZ275", "America/Swift_Current"),
    AmericaTegucigalpa("TZ276", "America/Tegucigalpa"),
    AmericaThule("TZ277", "America/Thule"),
    AmericaThunderBay("TZ278", "America/Thunder_Bay"),
    AmericaTijuana("TZ279", "America/Tijuana"),
    AmericaToronto("TZ280", "America/Toronto"),
    AmericaTortola("TZ281", "America/Tortola"),
    AmericaVancouver("TZ282", "America/Vancouver"),
    AmericaVirgin("TZ283", "America/Virgin"),
    AmericaWhitehorse("TZ284", "America/Whitehorse"),
    AmericaWinnipeg("TZ285", "America/Winnipeg"),
    AmericaYakutat("TZ286", "America/Yakutat"),
    AmericaYellowknife("TZ287", "America/Yellowknife"),
    AntarcticaCasey("TZ288", "Antarctica/Casey"),
    AntarcticaDavis("TZ289", "Antarctica/Davis"),
    AntarcticaDumontDUrville("TZ290", "Antarctica/DumontDUrville"),
    AntarcticaMacquarie("TZ291", "Antarctica/Macquarie"),
    AntarcticaMawson("TZ292", "Antarctica/Mawson"),
    AntarcticaMcMurdo("TZ293", "Antarctica/McMurdo"),
    AntarcticaPalmer("TZ294", "Antarctica/Palmer"),
    AntarcticaRothera("TZ295", "Antarctica/Rothera"),
    AntarcticaSouthPole("TZ296", "Antarctica/South_Pole"),
    AntarcticaSyowa("TZ297", "Antarctica/Syowa"),
    AntarcticaVostok("TZ298", "Antarctica/Vostok"),
    ArcticLongyearbyen("TZ299", "Arctic/Longyearbyen"),
    AsiaAden("TZ300", "Asia/Aden"),
    AsiaAmman("TZ301", "Asia/Amman"),
    AsiaAnadyr("TZ302", "Asia/Anadyr"),
    AsiaAqtau("TZ303", "Asia/Aqtau"),
    AsiaAqtobe("TZ304", "Asia/Aqtobe"),
    AsiaAshgabat("TZ305", "Asia/Ashgabat"),
    AsiaAshkhabad("TZ306", "Asia/Ashkhabad"),
    AsiaBaghdad("TZ307", "Asia/Baghdad"),
    AsiaBahrain("TZ308", "Asia/Bahrain"),
    AsiaBeirut("TZ309", "Asia/Beirut"),
    AsiaBishkek("TZ310", "Asia/Bishkek"),
    AsiaBrunei("TZ311", "Asia/Brunei"),
    AsiaCalcutta("TZ312", "Asia/Calcutta"),
    AsiaChoibalsan("TZ313", "Asia/Choibalsan"),
    AsiaChongqing("TZ314", "Asia/Chongqing"),
    AsiaChungking("TZ315", "Asia/Chungking"),
    AsiaDacca("TZ316", "Asia/Dacca"),
    AsiaDamascus("TZ317", "Asia/Damascus"),
    AsiaDhaka("TZ318", "Asia/Dhaka"),
    AsiaDili("TZ319", "Asia/Dili"),
    AsiaDushanbe("TZ320", "Asia/Dushanbe"),
    AsiaGaza("TZ321", "Asia/Gaza"),
    AsiaHarbin("TZ322", "Asia/Harbin"),
    AsiaHebron("TZ323", "Asia/Hebron"),
    AsiaHovd("TZ324", "Asia/Hovd"),
    AsiaIrkutsk("TZ325", "Asia/Irkutsk"),
    AsiaIstanbul("TZ326", "Asia/Istanbul"),
    AsiaJayapura("TZ327", "Asia/Jayapura"),
    AsiaJerusalem("TZ328", "Asia/Jerusalem"),
    AsiaKamchatka("TZ329", "Asia/Kamchatka"),
    AsiaKarachi("TZ330", "Asia/Karachi"),
    AsiaKashgar("TZ331", "Asia/Kashgar"),
    AsiaKathmandu("TZ332", "Asia/Kathmandu"),
    AsiaKatmandu("TZ333", "Asia/Katmandu"),
    AsiaKhandyga("TZ334", "Asia/Khandyga"),
    AsiaKolkata("TZ335", "Asia/Kolkata"),
    AsiaKrasnoyarsk("TZ336", "Asia/Krasnoyarsk"),
    AsiaKuching("TZ337", "Asia/Kuching"),
    AsiaKuwait("TZ338", "Asia/Kuwait"),
    AsiaMacao("TZ339", "Asia/Macao"),
    AsiaMacau("TZ340", "Asia/Macau"),
    AsiaMagadan("TZ341", "Asia/Magadan"),
    AsiaMakassar("TZ342", "Asia/Makassar"),
    AsiaNicosia("TZ343", "Asia/Nicosia"),
    AsiaNovokuznetsk("TZ344", "Asia/Novokuznetsk"),
    AsiaNovosibirsk("TZ345", "Asia/Novosibirsk"),
    AsiaOmsk("TZ346", "Asia/Omsk"),
    AsiaOral("TZ347", "Asia/Oral"),
    AsiaPhnomPenh("TZ348", "Asia/Phnom_Penh"),
    AsiaPontianak("TZ349", "Asia/Pontianak"),
    AsiaPyongyang("TZ350", "Asia/Pyongyang"),
    AsiaQatar("TZ351", "Asia/Qatar"),
    AsiaQyzylorda("TZ352", "Asia/Qyzylorda"),
    AsiaRangoon("TZ353", "Asia/Rangoon"),
    AsiaSaigon("TZ357", "Asia/Saigon"),
    AsiaSakhalin("TZ358", "Asia/Sakhalin"),
    AsiaSamarkand("TZ359", "Asia/Samarkand"),
    AsiaShanghai("TZ360", "Asia/Shanghai"),
    AsiaTashkent("TZ361", "Asia/Tashkent"),
    AsiaTbilisi("TZ362", "Asia/Tbilisi"),
    AsiaTelAviv("TZ363", "Asia/Tel_Aviv"),
    AsiaThimbu("TZ364", "Asia/Thimbu"),
    AsiaThimphu("TZ365", "Asia/Thimphu"),
    AsiaTokyo("TZ366", "Asia/Tokyo"),
    AsiaUjungPandang("TZ367", "Asia/Ujung_Pandang"),
    AsiaUlaanbaatar("TZ368", "Asia/Ulaanbaatar"),
    AsiaUlanBator("TZ369", "Asia/Ulan_Bator"),
    AsiaUrumqi("TZ370", "Asia/Urumqi"),
    AsiaUstNera("TZ371", "Asia/Ust-Nera"),
    AsiaVientiane("TZ372", "Asia/Vientiane"),
    AsiaVladivostok("TZ373", "Asia/Vladivostok"),
    AsiaYerevan("TZ374", "Asia/Yerevan"),
    AtlanticBermuda("TZ375", "Atlantic/Bermuda"),
    AtlanticCanary("TZ376", "Atlantic/Canary"),
    AtlanticCapeVerde("TZ377", "Atlantic/Cape_Verde"),
    AtlanticFaeroe("TZ378", "Atlantic/Faeroe"),
    AtlanticFaroe("TZ379", "Atlantic/Faroe"),
    AtlanticJanMayen("TZ380", "Atlantic/Jan_Mayen"),
    AtlanticMadeira("TZ381", "Atlantic/Madeira"),
    AtlanticReykjavik("TZ382", "Atlantic/Reykjavik"),
    AtlanticStHelena("TZ383", "Atlantic/St_Helena"),
    AtlanticStanley("TZ384", "Atlantic/Stanley"),
    AustraliaACT("TZ385", "Australia/ACT"),
    AustraliaBrokenHill("TZ386", "Australia/Broken_Hill"),
    AustraliaCanberra("TZ387", "Australia/Canberra"),
    AustraliaCurrie("TZ388", "Australia/Currie"),
    AustraliaEucla("TZ389", "Australia/Eucla"),
    AustraliaLHI("TZ390", "Australia/LHI"),
    AustraliaLindeman("TZ391", "Australia/Lindeman"),
    AustraliaLordHowe("TZ392", "Australia/Lord_Howe"),
    AustraliaMelbourne("TZ393", "Australia/Melbourne"),
    AustraliaNSW("TZ394", "Australia/NSW"),
    AustraliaNorth("TZ395", "Australia/North"),
    AustraliaQueensland("TZ396", "Australia/Queensland"),
    AustraliaSouth("TZ397", "Australia/South"),
    AustraliaTasmania("TZ398", "Australia/Tasmania"),
    AustraliaVictoria("TZ399", "Australia/Victoria"),
    AustraliaWest("TZ400", "Australia/West"),
    AustraliaYancowinna("TZ401", "Australia/Yancowinna"),
    BET("TZ402", "BET"),
    BST("TZ403", "BST"),
    BrazilAcre("TZ404", "Brazil/Acre"),
    BrazilDeNoronha("TZ405", "Brazil/DeNoronha"),
    BrazilEast("TZ406", "Brazil/East"),
    BrazilWest("TZ407", "Brazil/West"),
    CAT("TZ408", "CAT"),
    CET("TZ409", "CET"),
    CNT("TZ410", "CNT"),
    CST("TZ411", "CST"),
    CST6CDT("TZ412", "CST6CDT"),
    CanadaAtlantic("TZ413", "Canada/Atlantic"),
    CanadaCentral("TZ414", "Canada/Central"),
    CanadaEastSaskatchewan("TZ415", "Canada/East-Saskatchewan"),
    CanadaEastern("TZ416", "Canada/Eastern"),
    CanadaMountain("TZ417", "Canada/Mountain"),
    CanadaPacific("TZ418", "Canada/Pacific"),
    CanadaYukon("TZ419", "Canada/Yukon"),
    ChileContinental("TZ420", "Chile/Continental"),
    ChileEasterIsland("TZ421", "Chile/EasterIsland"),
    Cuba("TZ422", "Cuba"),
    EAT("TZ423", "EAT"),
    ECT("TZ424", "ECT"),
    EET("TZ425", "EET"),
    EST("TZ426", "EST"),
    EST5EDT("TZ427", "EST5EDT"),
    Eire("TZ428", "Eire"),
    EtcGMT("TZ429", "Etc/GMT"),
    EtcGMTPlus0("TZ430", "Etc/GMT+0"),
    EtcGMTPlus1("TZ431", "Etc/GMT+1"),
    EtcGMTPlus10("TZ432", "Etc/GMT+10"),
    EtcGMTPlus11("TZ433", "Etc/GMT+11"),
    EtcGMTPlus2("TZ434", "Etc/GMT+2"),
    EtcGMTPlus3("TZ435", "Etc/GMT+3"),
    EtcGMTPlus4("TZ436", "Etc/GMT+4"),
    EtcGMTPlus5("TZ437", "Etc/GMT+5"),
    EtcGMTPlus6("TZ438", "Etc/GMT+6"),
    EtcGMTPlus7("TZ439", "Etc/GMT+7"),
    EtcGMTPlus8("TZ440", "Etc/GMT+8"),
    EtcGMTPlus9("TZ441", "Etc/GMT+9"),
    EtcGMTMinus0("TZ442", "Etc/GMT-0"),
    EtcGMTMinus1("TZ443", "Etc/GMT-1"),
    EtcGMTMinus10("TZ444", "Etc/GMT-10"),
    EtcGMTMinus12("TZ445", "Etc/GMT-12"),
    EtcGMTMinus13("TZ446", "Etc/GMT-13"),
    EtcGMTMinus14("TZ447", "Etc/GMT-14"),
    EtcGMTMinus2("TZ448", "Etc/GMT-2"),
    EtcGMTMinus3("TZ449", "Etc/GMT-3"),
    EtcGMTMinus4("TZ450", "Etc/GMT-4"),
    EtcGMTMinus5("TZ451", "Etc/GMT-5"),
    EtcGMTMinus6("TZ452", "Etc/GMT-6"),
    EtcGMTMinus7("TZ453", "Etc/GMT-7"),
    EtcGMTMinus8("TZ454", "Etc/GMT-8"),
    EtcGMTMinus9("TZ455", "Etc/GMT-9"),
    EtcGMT0("TZ456", "Etc/GMT0"),
    EtcGreenwich("TZ457", "Etc/Greenwich"),
    EtcUCT("TZ458", "Etc/UCT"),
    EtcUTC("TZ459", "Etc/UTC"),
    EtcUniversal("TZ460", "Etc/Universal"),
    EtcZulu("TZ461", "Etc/Zulu"),
    EuropeAndorra("TZ462", "Europe/Andorra"),
    EuropeBelfast("TZ463", "Europe/Belfast"),
    EuropeBelgrade("TZ464", "Europe/Belgrade"),
    EuropeBratislava("TZ465", "Europe/Bratislava"),
    EuropeBrussels("TZ466", "Europe/Brussels"),
    EuropeBudapest("TZ467", "Europe/Budapest"),
    EuropeBusingen("TZ468", "Europe/Busingen"),
    EuropeChisinau("TZ469", "Europe/Chisinau"),
    EuropeCopenhagen("TZ470", "Europe/Copenhagen"),
    EuropeDublin("TZ471", "Europe/Dublin"),
    EuropeGibraltar("TZ472", "Europe/Gibraltar"),
    EuropeGuernsey("TZ473", "Europe/Guernsey"),
    EuropeIsleofMan("TZ474", "Europe/Isle_of_Man"),
    EuropeIstanbul("TZ475", "Europe/Istanbul"),
    EuropeJersey("TZ476", "Europe/Jersey"),
    EuropeKaliningrad("TZ477", "Europe/Kaliningrad"),
    EuropeKiev("TZ478", "Europe/Kiev"),
    EuropeLisbon("TZ479", "Europe/Lisbon"),
    EuropeLjubljana("TZ480", "Europe/Ljubljana"),
    EuropeLuxembourg("TZ481", "Europe/Luxembourg"),
    EuropeMadrid("TZ482", "Europe/Madrid"),
    EuropeMalta("TZ483", "Europe/Malta"),
    EuropeMariehamn("TZ484", "Europe/Mariehamn"),
    EuropeMinsk("TZ485", "Europe/Minsk"),
    EuropeMonaco("TZ486", "Europe/Monaco"),
    EuropeNicosia("TZ487", "Europe/Nicosia"),
    EuropePodgorica("TZ488", "Europe/Podgorica"),
    EuropeRiga("TZ489", "Europe/Riga"),
    EuropeRome("TZ490", "Europe/Rome"),
    EuropeSamara("TZ491", "Europe/Samara"),
    EuropeSanMarino("TZ492", "Europe/San_Marino"),
    EuropeSarajevo("TZ493", "Europe/Sarajevo"),
    EuropeSimferopol("TZ494", "Europe/Simferopol"),
    EuropeSkopje("TZ495", "Europe/Skopje"),
    EuropeSofia("TZ496", "Europe/Sofia"),
    EuropeTallinn("TZ497", "Europe/Tallinn"),
    EuropeTirane("TZ498", "Europe/Tirane"),
    EuropeTiraspol("TZ499", "Europe/Tiraspol"),
    EuropeUzhgorod("TZ500", "Europe/Uzhgorod"),
    EuropeVaduz("TZ501", "Europe/Vaduz"),
    EuropeVatican("TZ502", "Europe/Vatican"),
    EuropeVienna("TZ503", "Europe/Vienna"),
    EuropeVilnius("TZ504", "Europe/Vilnius"),
    EuropeVolgograd("TZ505", "Europe/Volgograd"),
    EuropeWarsaw("TZ506", "Europe/Warsaw"),
    EuropeZagreb("TZ507", "Europe/Zagreb"),
    EuropeZaporozhye("TZ508", "Europe/Zaporozhye"),
    EuropeZurich("TZ509", "Europe/Zurich"),
    GB("TZ510", "GB"),
    GBEire("TZ511", "GB-Eire"),
    GMT("TZ512", "GMT"),
    GMT0("TZ513", "GMT0"),
    Greenwich("TZ514", "Greenwich"),
    HST("TZ515", "HST"),
    Hongkong("TZ516", "Hongkong"),
    IET("TZ517", "IET"),
    Iceland("TZ518", "Iceland"),
    IndianAntananarivo("TZ519", "Indian/Antananarivo"),
    IndianChagos("TZ520", "Indian/Chagos"),
    IndianChristmas("TZ521", "Indian/Christmas"),
    IndianCocos("TZ522", "Indian/Cocos"),
    IndianComoro("TZ523", "Indian/Comoro"),
    IndianKerguelen("TZ524", "Indian/Kerguelen"),
    IndianMahe("TZ525", "Indian/Mahe"),
    IndianMaldives("TZ526", "Indian/Maldives"),
    IndianMauritius("TZ527", "Indian/Mauritius"),
    IndianMayotte("TZ528", "Indian/Mayotte"),
    IndianReunion("TZ529", "Indian/Reunion"),
    Iran("TZ530", "Iran"),
    Jamaica("TZ531", "Jamaica"),
    Japan("TZ532", "Japan"),
    Kwajalein("TZ533", "Kwajalein"),
    Libya("TZ534", "Libya"),
    MET("TZ535", "MET"),
    MIT("TZ536", "MIT"),
    MST("TZ537", "MST"),
    MST7MDT("TZ538", "MST7MDT"),
    NET("TZ542", "NET"),
    NST("TZ543", "NST"),
    NZ("TZ544", "NZ"),
    NZCHAT("TZ545", "NZ-CHAT"),
    Navajo("TZ546", "Navajo"),
    PNT("TZ547", "PNT"),
    PRC("TZ548", "PRC"),
    PRT("TZ549", "PRT"),
    PST("TZ550", "PST"),
    PST8PDT("TZ551", "PST8PDT"),
    PacificApia("TZ552", "Pacific/Apia"),
    PacificChatham("TZ553", "Pacific/Chatham"),
    PacificChuuk("TZ554", "Pacific/Chuuk"),
    PacificEaster("TZ555", "Pacific/Easter"),
    PacificEfate("TZ556", "Pacific/Efate"),
    PacificEnderbury("TZ557", "Pacific/Enderbury"),
    PacificFakaofo("TZ558", "Pacific/Fakaofo"),
    PacificFunafuti("TZ559", "Pacific/Funafuti"),
    PacificGalapagos("TZ560", "Pacific/Galapagos"),
    PacificGambier("TZ561", "Pacific/Gambier"),
    PacificJohnston("TZ562", "Pacific/Johnston"),
    PacificKiritimati("TZ563", "Pacific/Kiritimati"),
    PacificKosrae("TZ564", "Pacific/Kosrae"),
    PacificKwajalein("TZ565", "Pacific/Kwajalein"),
    PacificMajuro("TZ566", "Pacific/Majuro"),
    PacificMarquesas("TZ567", "Pacific/Marquesas"),
    PacificNauru("TZ568", "Pacific/Nauru"),
    PacificNiue("TZ569", "Pacific/Niue"),
    PacificNorfolk("TZ570", "Pacific/Norfolk"),
    PacificNoumea("TZ571", "Pacific/Noumea"),
    PacificPagoPago("TZ572", "Pacific/Pago_Pago"),
    PacificPalau("TZ573", "Pacific/Palau"),
    PacificPitcairn("TZ574", "Pacific/Pitcairn"),
    PacificPohnpei("TZ575", "Pacific/Pohnpei"),
    PacificPonape("TZ576", "Pacific/Ponape"),
    PacificPortMoresby("TZ577", "Pacific/Port_Moresby"),
    PacificRarotonga("TZ578", "Pacific/Rarotonga"),
    PacificSaipan("TZ579", "Pacific/Saipan"),
    PacificSamoa("TZ580", "Pacific/Samoa"),
    PacificTahiti("TZ581", "Pacific/Tahiti"),
    PacificTarawa("TZ582", "Pacific/Tarawa"),
    PacificTongatapu("TZ583", "Pacific/Tongatapu"),
    PacificTruk("TZ584", "Pacific/Truk"),
    PacificWake("TZ585", "Pacific/Wake"),
    PacificWallis("TZ586", "Pacific/Wallis"),
    PacificYap("TZ587", "Pacific/Yap"),
    Poland("TZ588", "Poland"),
    Portugal("TZ589", "Portugal"),
    ROK("TZ590", "ROK"),
    SST("TZ591", "SST"),
    Singapore("TZ592", "Singapore"),
    SystemVAST4("TZ593", "SystemV/AST4"),
    SystemVAST4ADT("TZ594", "SystemV/AST4ADT"),
    SystemVCST6("TZ595", "SystemV/CST6"),
    SystemVCST6CDT("TZ596", "SystemV/CST6CDT"),
    SystemVEST5("TZ597", "SystemV/EST5"),
    SystemVEST5EDT("TZ598", "SystemV/EST5EDT"),
    SystemVHST10("TZ599", "SystemV/HST10"),
    SystemVMST7("TZ600", "SystemV/MST7"),
    SystemVMST7MDT("TZ601", "SystemV/MST7MDT"),
    SystemVPST8("TZ602", "SystemV/PST8"),
    SystemVPST8PDT("TZ603", "SystemV/PST8PDT"),
    SystemVYST9("TZ604", "SystemV/YST9"),
    SystemVYST9YDT("TZ605", "SystemV/YST9YDT"),
    Turkey("TZ606", "Turkey"),
    UCT("TZ607", "UCT"),
    USAleutian("TZ608", "US/Aleutian"),
    USHawaii("TZ609", "US/Hawaii"),
    USIndianaStarke("TZ610", "US/Indiana-Starke"),
    USMichigan("TZ611", "US/Michigan"),
    USPacificNew("TZ612", "US/Pacific-New"),
    USSamoa("TZ613", "US/Samoa"),
    UTC("TZ614", "UTC"),
    Universal("TZ615", "Universal"),
    VST("TZ616", "VST"),
    WSU("TZ617", "W-SU"),
    WET("TZ618", "WET"),
    Zulu("TZ619", "Zulu"),
    AsiaChita("TZ620", "Asia/Chita"),
    PacificBougainville("TZ621", "Pacific/Bougainville"),
    AntarcticaTroll("TZ622", "Antarctica/Troll"),
    AsiaSrednekolymsk("TZ623", "Asia/Srednekolymsk");

    private static final Map<String, WorkdayTimeZone> INTERNAL_ID_MAP;
    private static final Map<TimeZone, WorkdayTimeZone> JAVA_TIMEZONE_MAP;
    private static final Map<String, WorkdayTimeZone> JAVA_TIMEZONE_ID_MAP;
    // Max time difference between supported workday timezones (in milliseconds)
    private static final long MAX_TIMEZONE_DIFF;
    //Server Default WorkdayTimeZone
    public static final WorkdayTimeZone DEFAULT;

    private static final Logger LOG = LoggerFactory.getLogger(WorkdayTimeZone.class.getName());
    private static volatile boolean logging = true;

    static {
        final Map<String, WorkdayTimeZone> internalIdMap = new HashMap<>();
        final Map<TimeZone, WorkdayTimeZone> javaTimeZoneMap = new HashMap<>();
        final Map<String, WorkdayTimeZone> javaTimeZoneIdMap = new HashMap<>();
        for (final WorkdayTimeZone workdayTimeZone : WorkdayTimeZone.values()) {
            if (internalIdMap.put(workdayTimeZone.getInternalTimeZoneID(), workdayTimeZone) != null) {
                System.out.println("Duplicated WorkdayTimeZone: " + workdayTimeZone.getInternalTimeZoneID());
            }
            if(!workdayTimeZone.valid){
                System.out.println(workdayTimeZone);
                continue;
            }
            javaTimeZoneMap.put(workdayTimeZone.getJavaTimeZone(), workdayTimeZone);
            javaTimeZoneIdMap.put(workdayTimeZone.getJavaTimeZoneID(), workdayTimeZone);
        }
        INTERNAL_ID_MAP = ImmutableMap.copyOf(internalIdMap);
        JAVA_TIMEZONE_MAP = ImmutableMap.copyOf(javaTimeZoneMap);
        JAVA_TIMEZONE_ID_MAP = ImmutableMap.copyOf(javaTimeZoneIdMap);
        MAX_TIMEZONE_DIFF = calculateMaxTimeZoneDifference(JAVA_TIMEZONE_MAP);
        DEFAULT = getWorkdayTimeZoneFromJavaTimeZone(TimeZone.getDefault());
    }

    private final String internalTimezoneID;
    private final String javaTimezoneID;
    private final TimeZone javaTimezone;
    private final boolean valid;

    WorkdayTimeZone(final String internalTimezoneID, final String javaTimezoneID) {

        this.internalTimezoneID = internalTimezoneID;
        this.javaTimezoneID = javaTimezoneID;
        this.javaTimezone = TimeZone.getTimeZone(javaTimezoneID);
        this.valid = javaTimezone.getID().equals(javaTimezoneID);
    }

    public TimeZone getJavaTimeZone() {
        return this.javaTimezone;
    }

    public String getInternalTimeZoneID() {
        return this.internalTimezoneID;
    }

    public String getJavaTimeZoneID() {
        return this.javaTimezoneID;
    }

    public static long getMaxTimeZoneDifference() {
        return MAX_TIMEZONE_DIFF;
    }

    public static WorkdayTimeZone getWorkdayTimeZoneFromInternalTimeZoneID(final String internalTimezoneID) {
        if (internalTimezoneID == null) {
            // nothing to find
            return null;
        }
        final WorkdayTimeZone foundWorkdayTimeZone = INTERNAL_ID_MAP.get(internalTimezoneID);
        if (foundWorkdayTimeZone != null) {
            return foundWorkdayTimeZone;
        }
        // not found
        return null;
    }

    public static WorkdayTimeZone getWorkdayTimeZoneFromJavaTimeZone(final TimeZone javaTimeZone) {
        if (javaTimeZone == null) {
            // nothing to find
            return null;
        }
        final WorkdayTimeZone foundWorkdayTimeZone = JAVA_TIMEZONE_MAP.get(javaTimeZone);
        if (foundWorkdayTimeZone != null) {
            return foundWorkdayTimeZone;
        }
        final WorkdayTimeZone foundWorkdayTimeZoneThroughID = JAVA_TIMEZONE_ID_MAP.get(javaTimeZone.getID());
        if (logging) {
            logging = false;
            LOG.info("TimeZone: " + javaTimeZone +
                    (foundWorkdayTimeZoneThroughID == null
                            ? " not found"
                            : " found by " + foundWorkdayTimeZoneThroughID.getJavaTimeZone()));
        }
        return foundWorkdayTimeZoneThroughID;
    }

    static long calculateMaxTimeZoneDifference(final Map<TimeZone, WorkdayTimeZone> JAVA_TIMEZONE_MAP) {
        if (JAVA_TIMEZONE_MAP == null || JAVA_TIMEZONE_MAP.isEmpty()) {
            return 0;
        }
        final Set<Integer> timeZoneOffsets = new HashSet<Integer>();
        JAVA_TIMEZONE_MAP.keySet().stream().filter(Objects::nonNull).forEach((timeZone) -> {
            timeZoneOffsets.add(timeZone.getRawOffset());
            timeZoneOffsets.add(timeZone.getRawOffset() + timeZone.getDSTSavings());
        });
        if (!timeZoneOffsets.isEmpty()) {
            return Math.abs(Collections.max(timeZoneOffsets) - Collections.min(timeZoneOffsets));
        }

        return 0;
    }

    @Override
    public String toString() {
        return "WorkdayTimeZone{" +
                "internalTimezoneID='" + internalTimezoneID + '\'' +
                ", javaTimezoneID='" + javaTimezoneID + '\'' +
                ", javaTimezone=" + javaTimezone +
                '}' + name();
    }

    public static void main(String[] args) {

//        System.out.println(WorkdayTimeZone.USPacificNew);

        String[] availableIDs = TimeZone.getAvailableIDs();
        for (String availableID : availableIDs) {
//            System.out.println(availableID);
        }

        for (final WorkdayTimeZone workdayTimeZone : WorkdayTimeZone.values()) {
            if (workdayTimeZone.javaTimezone.getRawOffset() == 0 && workdayTimeZone.javaTimezone.getID().contains("GMT") && !workdayTimeZone.javaTimezone.getID().contains("Etc")) {

                System.out.println(workdayTimeZone);
            }
        }

        WorkdayTimeZone gmt = JAVA_TIMEZONE_MAP.get(TimeZone.getTimeZone("GMT"));
        System.out.println("---------------");
        System.out.println(gmt);

         gmt = JAVA_TIMEZONE_MAP.get(TimeZone.getTimeZone("US/Pacific"));
        System.out.println("---------------");
        System.out.println(gmt);
    }
//sun.util.calendar.ZoneInfo[id="GMT",offset=0,dstSavings=0,useDaylight=false,transitions=0,lastRule=null]
//sun.util.calendar.ZoneInfo[id="US/Pacific-New",offset=-28800000,dstSavings=3600000,useDaylight=true,transitions=185,lastRule=java.util.SimpleTimeZone[id=US/Pacific-New,offset=-28800000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]]
}
