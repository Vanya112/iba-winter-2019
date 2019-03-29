function getStatusCodes(): void {

}

export const STATUS_CODES =
  [{
    'id': 74,
    'code': 'ALLOCF',
    'description': 'Database has an allocation failure.',
    'objectType': {'id': 1, 'name': 'IMS_DATABASE', 'description': 'Database'},
    'objectTypeName': null,
    'issueGrouping': true,
    'createIncidents': true,
    'status': 'VALIDATED'
  }, {
    'id': 138,
    'code': 'SUSPEND',
    'description': 'Transaction has messages on the suspend queue.',
    'objectType': {'id': 2, 'name': 'IMS_TRANSACTION', 'description': 'Transaction'},
    'objectTypeName': null,
    'issueGrouping': true,
    'createIncidents': true,
    'status': 'NEW'
  }, {
    'id': 142,
    'code': 'ALLOCF,NOTOPEN,STOACC',
    'description': 'Database has an allocation failure. Database or area is not open. Database is stopped for access and is offline.',
    'objectType': {'id': 1, 'name': 'IMS_DATABASE', 'description': 'Database'},
    'objectTypeName': null,
    'issueGrouping': true,
    'createIncidents': true,
    'status': 'VALIDATED'
  }, {
    'id': 141,
    'code': 'TRACE',
    'description': 'Program is being traced.',
    'objectType': {'id': 3, 'name': 'IMS_PROGRAM', 'description': 'Program'},
    'objectTypeName': null,
    'issueGrouping': true,
    'createIncidents': true,
    'status': 'VALIDATED'
  }, {
    'id': 75,
    'code': 'STOPPED',
    'description': 'Region is stopped.',
    'objectType': {'id': 4, 'name': 'IMS_REGION', 'description': 'Region'},
    'objectTypeName': null,
    'issueGrouping': true,
    'createIncidents': false,
    'status': 'VALIDATED'
  }, {
    'id': 131,
    'code': 'STOP,AREO*,ICOPY',
    'description': 'Tablespace is stopped. Tablespace is in advisory REORG-pending and informational COPY-pending status.',
    'objectType': {'id': 13, 'name': 'DB2_TS', 'description': 'Tablespace'},
    'objectTypeName': null,
    'issueGrouping': true,
    'createIncidents': false,
    'status': 'VALIDATED'
  }, {
    'id': 135,
    'code': 'RW,COPY',
    'description': 'Tablespace is in COPY-pending status.',
    'objectType': {'id': 13, 'name': 'DB2_TS', 'description': 'Tablespace'},
    'objectTypeName': null,
    'issueGrouping': true,
    'createIncidents': true,
    'status': 'VALIDATED'
  }, {
    'id': 132,
    'code': 'RW,RBDP,UTUT',
    'description': 'Index is in REBUILD-pending status. Index is serialized for utility access and available for read-only access.',
    'objectType': {'id': 14, 'name': 'DB2_INDEX', 'description': 'Index'},
    'objectTypeName': null,
    'issueGrouping': true,
    'createIncidents': false,
    'status': 'VALIDATED'
  }, {
    'id': 136,
    'code': 'STOPABN',
    'description': 'The stored procedure was stopped because of a previous abnormal termination of the stored procedure application. SQL CALL requests for the stored procedure are rejected.',
    'objectType': {'id': 18, 'name': 'DB2_SP', 'description': 'Stored procedure'},
    'objectTypeName': null,
    'issueGrouping': true,
    'createIncidents': true,
    'status': 'NEW'
  }, {
    'id': 76,
    'code': 'BACKOUT',
    'description': 'Incomplete backout exists for the database that prevents the use of the database.',
    'objectType': {'id': 1, 'name': 'IMS_DATABASE', 'description': 'Database'},
    'objectTypeName': null,
    'issueGrouping': true,
    'createIncidents': true,
    'status': 'VALIDATED'
  }];
