"use strict";
var __extends =
  (this && this.__extends) ||
  (function () {
    var extendStatics = function (d, b) {
      extendStatics =
        Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array &&
          function (d, b) {
            d.__proto__ = b;
          }) ||
        function (d, b) {
          for (var p in b)
            if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p];
        };
      return extendStatics(d, b);
    };
    return function (d, b) {
      if (typeof b !== "function" && b !== null)
        throw new TypeError(
          "Class extends value " + String(b) + " is not a constructor or null"
        );
      extendStatics(d, b);
      function __() {
        this.constructor = d;
      }
      d.prototype =
        b === null
          ? Object.create(b)
          : ((__.prototype = b.prototype), new __());
    };
  })();

// variabili dom
var container = document.getElementById("box_User");
var btn_ricarica = document.getElementById("bottone-ricarica");
var inputRicarica = document.getElementById("input_Ricarica");
var cardText1 = document.querySelector(".saldo");
var cardText2 = document.querySelector(".chiamata");
var inputChiamata = document.getElementById("input_chiama");
var bottoneChiama = document.getElementById("bottone-chiama");
var bottoneAzzera = document.getElementById("bottone-azzera");
// classe astratta per smartphone
var Smartphone = /** @class */ (function () {
  function Smartphone(carica, numeroChiamate) {
    if (carica === void 0) {
      carica = 0;
    }
    if (numeroChiamate === void 0) {
      numeroChiamate = 0;
    }
    this.carica = carica;
    this.numeroChiamate = numeroChiamate;
  }
  return Smartphone;
})();
// classe per estender smartphone. firstUser
var FirstUser = /** @class */ (function (_super) {
  __extends(FirstUser, _super);
  function FirstUser(carica, numeroChiamate) {
    if (carica === void 0) {
      carica = 0;
    }
    if (numeroChiamate === void 0) {
      numeroChiamate = 0;
    }
    return _super.call(this, carica, numeroChiamate) || this;
  }
  FirstUser.prototype.ricarica = function (n) {
    return this.carica + n;
  };
  FirstUser.prototype.chiamata = function (n) {
    var costoMin = 0.2;
    this.numeroChiamate++;
    return (this.carica -= n * costoMin);
  };
  FirstUser.prototype.azzeraChiamate = function () {
    return (this.numeroChiamate = 0);
  };
  FirstUser.prototype.getNumeroChiamate = function () {
    cardText2.innerHTML = "Chiamate Effettuate: ".concat(this.numeroChiamate);
    return this.numeroChiamate;
  };
  return FirstUser;
})(Smartphone);
// creazione istanza del signor eleuterio
var eleuterio = new FirstUser();
// bottone evento al click faccio una ricarica soldi
btn_ricarica.addEventListener("click", function () {
  // allo schiacciare del pulsante, faccio ricarica
  var ricarica = Number(inputRicarica.value);
  eleuterio.carica = eleuterio.ricarica(ricarica);
  cardText1.innerHTML = "Danari Disponbile: ".concat(
    Number(eleuterio.carica.toFixed(2)),
    "\u00A3"
  );
  console.log(eleuterio);
  inputRicarica.value = "";
});
// bottone evento al click aggiungo una chiamata. l'input sono i minuti *0.20 che vengono sotratti a carica
bottoneChiama.addEventListener("click", function () {
  var minutiChiamata = Number(inputChiamata.value);
  eleuterio.chiamata(minutiChiamata);
  cardText1.innerHTML = "Danari Disponbile: ".concat(
    Number(eleuterio.carica.toFixed(2)),
    "\u00A3"
  );
  eleuterio.getNumeroChiamate();
  inputChiamata.value = "";
});
bottoneAzzera.addEventListener("click", function () {
  eleuterio.azzeraChiamate();
  eleuterio.getNumeroChiamate();
});
