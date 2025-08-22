import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'celsiusToFahrenheit',
  standalone: true
})
export class CelsiusToFahrenheitPipe implements PipeTransform {
  transform(value: number | string): string {
    const n = Number(value);
    if (isNaN(n)) return '';
    const f = (n * 9/5) + 32;
    return `${f.toFixed(1)}F`;
  }
}
