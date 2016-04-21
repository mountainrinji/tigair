
TigairApp.config(function($translateProvider) {
  $translateProvider.translations('en', {
	  aircraftdata_aircraft: 'Aircraft: ',
    HEADLINE: 'Hello there, This is my awesome app!',
    INTRO_TEXT: 'And it has i18n support!'
  })
  .translations('pl', {
	aircraftdata_statusObslugowy: 'STATUS OBSŁUGOWY SAMOLOTU',
    aircraftdata_aircraft: 'Samolot: ',
    aircraftdata_serialno: 'Nr. fabryczny: ',
    aircraftdata_manufacturedDate: 'Data produkcji: ',
    aircraftdata_typeCertificate: 'Certyfikat typu: ',
    aircraftdata_totalTime: 'Nalot',
    
    activityStatusTable_lp: 'Lp',
    activityStatusTable_activityName: 'Paczka obsługowa/SB/AD',
    activityStatusTable_activityType: 'Typ operacji',
    activityStatusTable_hoursInterval: 'Interwał godzinowy',
    activityStatusTable_calendarInterval: 'Interwał kalendarzowy',
    activityStatusTable_cyclesInterval: 'Interwał cykli',
    activityStatusTable_executedHours: 'Wykonano przy nalocie',
    activityStatusTable_executedDate: 'Wykonano dnia',
    activityStatusTable_executedCycles: 'Wykonano przy cyklach',
    activityStatusTable_dueHours: 'Do wykonania przy nalocie',
    activityStatusTable_dueDate: 'Do wykonania dnia',
    activityStatusTable_dueCycles: 'Do wykonania przy cyklach',
    activityStatusTable_hoursLeft: 'Zostało godzin',
    activityStatusTable_daysLeft: 'Zostało dni',
    activityStatusTable_cyclesLeft: 'Zostało cykli',
    activityStatusTable_crs: 'Ident. prac obsługowych',
    activityStatusTable_additionalNotes: 'Uwagi',
    
    actionType_overhaul: 'Naprawa główna',
    actionType_replace: 'Wymiana',
    actionType_inspect: 'Inspekcja',
    actionType_lubricate: 'Smarowanie',
    actionType_clean: 'Czyszczenie',
    actionType_oncondition: 'On-condition',
    
    airframe: 'Płatowiec',
    engine: 'Silnik',
    propeller: 'Śmigło',
    
    engine_model: 'Model: ',
    engine_serialNo: 'Nr fabryczny: ',
    engine_manufacturedYear: 'Rok produkcji: ',
    engine_certificationType: 'Certyfikat typu: ',
    engine_timeSinceOH: 'Nalot: ',
    
    propeller_model: 'Model: ',
    propeller_serialNo: 'Nr fabryczny: ',
    propeller_manufacturedYear: 'Rok produkcji: ',
    propeller_certificationType: 'Certyfikat typu: ',
    propeller_timeSinceOH: 'Nalot od naprawy głównej: ',
    propeller_totalTime: 'Nalot całkowity:',
    
    part_model: 'Model: ',
    part_serialNo: 'Nr fabryczny: ',
    part_manufacturedYear: 'Rok produkcji: ',
    part_certificationType: 'Certyfikat typu: ',
    part_timeSinceOH: 'Nalot od naprawy głównej: ',
    part_totalTime: 'Nalot całkowity: '
    	
  });
  
});