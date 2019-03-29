import { Component, OnInit } from '@angular/core';
import {SampleService} from '../services/sample.service';
import {StatusCodePipe} from '../pipes/status-code.pipe';
import {StatusCode} from '../models/statusCode';

@Component({
  selector: 'app-status-code',
  templateUrl: './status-code.component.html',
  styleUrls: ['./status-code.component.scss']
})
export class StatusCodeComponent implements OnInit {


  title = 'SampleA';
  data: StatusCode[];
  constructor(private service: SampleService) {
    this.title = service.getTitle();
    this.data = service.getStatusCodes();
  }
  ngOnInit() {
    return null;
  }

}
