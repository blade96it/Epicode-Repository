import { Directive, ElementRef } from '@angular/core';

@Directive({
  selector: '[appEvidenziatore]'
})
export class EvidenziatoreDirective {

  constructor(private elemento: ElementRef) {
    this.elemento.nativeElement.style.backgroundColor = "#fcfccc";
    this.elemento.nativeElement.style.color = "black"
  }

}
