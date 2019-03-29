import {Directive, ElementRef, HostListener} from '@angular/core';

@Directive({
  selector: '[appHighLight]'
})

export class StyleDirective {

  constructor(public ref: ElementRef) {
  }
  @HostListener('mouseenter') clicknable() {
    this.ref.nativeElement.style.backgroundColor = 'red';
  }

}
