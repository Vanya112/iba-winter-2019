import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {FormsModule} from '@angular/forms';
import { StatusCodeComponent } from './status-code/status-code.component';
import { StatusCodePipe } from './pipes/status-code.pipe';
import { StyleDirective } from './directives/style.directive';

@NgModule({
  declarations: [
    AppComponent,
    StatusCodeComponent,
    StatusCodePipe,
    StyleDirective
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
