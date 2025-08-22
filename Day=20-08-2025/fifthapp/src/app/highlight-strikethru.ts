import { Directive, ElementRef } from '@angular/core';

@Directive({
  selector: '[appHighlightStrikethru]',
  standalone: true
})
export class HighlightStrikethruDirective {
  constructor(private elementRef: ElementRef) {
    const el = this.elementRef.nativeElement as HTMLElement;
    el.style.backgroundColor = 'yellow';
    el.style.textDecoration = 'line-through';
    el.style.fontWeight = 'bold';
  }
}
