import {ObjectType} from './objectType';

export class StatusCode {
 /* id: number;
  code: string;
  description: string;
  objectType: ObjectType;
  objectTypeName: string;
  issueGrouping: boolean;
  createIncidents: boolean;
  status: string;*/

  constructor(public id: number, public code: string, public description: string, public objectType: ObjectType, public objectTypeName: string, public issueGrouping: boolean, public createIncidents: boolean, public status: string) {
   /* this.id = id;
    this.code = code;
    this.description = description;
    this.objectType = objectType;
    this.objectTypeName = objectTypeName;
    this.issueGrouping = issueGrouping;
    this.createIncidents = createIncidents;
    this.status = status;*/
  }
}
