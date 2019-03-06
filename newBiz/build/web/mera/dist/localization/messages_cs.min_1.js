/*! jQuery Validation Plugin - v1.15.0 - 2/24/2016
 * http://jqueryvalidation.org/
 * Copyright (c) 2016 Jörn Zaefferer; Licensed MIT */
!function(a){"function"==typeof define&&define.amd?define(["jquery","../jquery.validate.min"],a):"object"==typeof module&&module.exports?module.exports=a(require("jquery")):a(jQuery)}(function(a){a.extend(a.validator.messages,{required:"Tento údaj je povinný.",remote:"Prosím, opravte tento údaj.",email:"Prosím, zadejte platný e-mail.",url:"Prosím, zadejte platné URL.",date:"Prosím, zadejte platné datum.",dateISO:"Prosím, zadejte platné datum (ISO).",number:"Prosím, zadejte číslo.",digits:"Prosím, zadávejte pouze číslice.",creditcard:"Prosím, zadejte číslo kreditní karty.",equalTo:"Prosím, zadejte znovu stejnou hodnotu.",extension:"Prosím, zadejte soubor se správnou příponou.",maxlength:a.validator.format("Prosím, zadejte nejvíce {0} znaků."),minlength:a.validator.format("Prosím, zadejte nejméně {0} znaků."),rangelength:a.validator.format("Prosím, zadejte od {0} do {1} znaků."),range:a.validator.format("Prosím, zadejte hodnotu od {0} do {1}."),max:a.validator.format("Prosím, zadejte hodnotu menší nebo rovnu {0}."),min:a.validator.format("Prosím, zadejte hodnotu větší nebo rovnu {0}.")})});