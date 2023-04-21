import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'toMaiuscolo'
})
export class toMaiuscolo implements PipeTransform {

  transform(testo: string): string {
    return testo.toUpperCase();
  }

}
