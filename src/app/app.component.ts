import { Component } from '@angular/core';
import {SampleService} from './services/sample.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'SampleA';

  constructor(private service: SampleService) {
    this.title = service.getTitle();
  }
  clickHappened($event) {
    console.log($event);
  }

}
