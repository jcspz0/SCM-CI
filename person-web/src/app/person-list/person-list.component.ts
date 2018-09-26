import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { PersonService } from '../person.service';
import { Person } from '../model/person';

@Component({
  selector: 'person-list',
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.css']
})
export class PersonListComponent implements OnInit {

  persons: Observable<Person[]>;

  constructor(private personService: PersonService) { }

  ngOnInit() {
    this.reloadData();
  }

  deletePerson() {
    this.personService.deleteAll()
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log('ERROR: ' + error));
  }

  reloadData() {
    this.persons = this.personService.getPersonList();
    console.log(this.persons);
  }

}
