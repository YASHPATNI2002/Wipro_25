import { HighlightStrikethruDirective } from './highlight-strikethru';

import { ElementRef } from '@angular/core';

describe('HighlightStrikethruDirective', () => {
  it('should create an instance', () => {
    // ✅ create a fake <p> element to attach directive
    const elementRef = new ElementRef(document.createElement('p'));

    const directive = new HighlightStrikethruDirective(elementRef);
    expect(directive).toBeTruthy();
  });
});
