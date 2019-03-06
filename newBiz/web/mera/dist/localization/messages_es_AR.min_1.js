/*! jQuery Validation Plugin - v1.15.0 - 2/24/2016
 * http://jqueryvalidation.org/
 * Copyright (c) 2016 Jörn Zaefferer; Licensed MIT */
!function(a){"function"==typeof define&&define.amd?define(["jquery","../jquery.validate.min"],a):"object"==typeof module&&module.exports?module.exports=a(require("jquery")):a(jQuery)}(function(a){a.extend(a.validator.messages,{required:"Este campo es obligatorio.",remote:"Por favor, completá este campo.",email:"Por favor, escribí una dirección de correo válida.",url:"Por favor, escribí una URL válida.",date:"Por favor, escribí una fecha válida.",dateISO:"Por favor, escribí una fecha (ISO) válida.",number:"Por favor, escribí un número entero válido.",digits:"Por favor, escribí sólo dígitos.",creditcard:"Por favor, escribí un número de tarjeta válido.",equalTo:"Por favor, escribí el mismo valor de nuevo.",extension:"Por favor, escribí un valor con una extensión aceptada.",maxlength:a.validator.format("Por favor, no escribas más de {0} caracteres."),minlength:a.validator.format("Por favor, no escribas menos de {0} caracteres."),rangelength:a.validator.format("Por favor, escribí un valor entre {0} y {1} caracteres."),range:a.validator.format("Por favor, escribí un valor entre {0} y {1}."),max:a.validator.format("Por favor, escribí un valor menor o igual a {0}."),min:a.validator.format("Por favor, escribí un valor mayor o igual a {0}."),nifES:"Por favor, escribí un NIF válido.",nieES:"Por favor, escribí un NIE válido.",cifES:"Por favor, escribí un CIF válido."})});