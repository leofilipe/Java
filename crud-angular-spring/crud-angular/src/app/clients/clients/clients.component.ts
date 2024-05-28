import { Component } from '@angular/core';
import { Client } from '../model/client';

import { MatTableModule } from '@angular/material/table';

@Component({
  selector: 'app-clients',
  standalone: true,
  imports: [MatTableModule],
  templateUrl: './clients.component.html',
  styleUrl: './clients.component.scss'
})
export class ClientsComponent {

  clients : Client[];
  displayedColumns: string[];

  constructor(){
    /*_cpf:string;
    name: string;
    birth: string;
    gender: string; */
    this.clients = [
      { _cpf: '055.671.004-50', name: 'Leonardo Carvalho', gender: 'M', birth: '06/15/1985'}
    ];
    this.displayedColumns = ['_cpf', 'name', 'gender', 'birth']
  }
}
