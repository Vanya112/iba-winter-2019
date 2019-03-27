import { Injectable } from '@angular/core';

import {STATUS_CODES} from 'src/app/mocks/status-codes-mock';

@Injectable({
  providedIn: 'root'
})
export class SampleService {

  statusData: any;
  data: any;
  title = 'Hello';
  getTitle(): string {
    return this.title;
  }
  constructor() {
  }

  getStatusCodes(): any {
   // this.data = codes;
    return STATUS_CODES;
  }


}
