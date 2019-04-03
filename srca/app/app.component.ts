import { Component } from '@angular/core';
import { SubmitService } from '../app/services/submit.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular';
  constructor(public service: SubmitService) {}
}
