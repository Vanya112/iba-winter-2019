import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SubmitService {

  constructor(private http: HttpClient) { }
  submitCommand() {
   this.http.get<string>('http://localhost:8080/api/student/getAllStudents').subscribe((res) => {
      console.log(res);
    });
  }
  executeCommand() {
    this.http.post('http://localhost:8080/api/student/execute', '/DIS TRAN ADDINV' , {responseType: 'text'}).subscribe((res) => {
      console.log(res);
      return res;
    });
  }
  db2Connect() {
    this.http.post('http://localhost:8080/api/student/db2', '-DIS DDS' , {responseType: 'text'}).subscribe((res) => {
      console.log(res);
      return res;
    });
  }
  ftpConnect() {
    this.http.post('http://localhost:8080/api/student/ftp', '-DIS DDS' , {responseType: 'text'}).subscribe((res) => {
      console.log(res);
      return res;
    });
  }
}
