import { Pipe, PipeTransform } from '@angular/core';


@Pipe({
  name: 'statusCode'
})
export class StatusCodePipe implements PipeTransform {
  transform(value: any): any {
    value.object = value.objectType.name;
    return value;
  }

}
