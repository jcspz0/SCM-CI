import { Component, OnInit, Input } from '@angular/core';
import { PersonService } from '../person.service';
import { Person } from '../model/person';

import { PersonListComponent } from '../person-list/person-list.component';

@Component({
  selector: 'person-details',
  templateUrl: './person-details.component.html',
  styleUrls: ['./person-details.component.css']
})
export class PersonDetailsComponent implements OnInit {

  @Input() person: Person;

  constructor(private personService: PersonService, private listComponent: PersonListComponent) { }

  ngOnInit() {
  }

  /*updateActive(isActive: boolean) {
    this.personService.updatePerson(this.person.id,
      { name: this.person.name, lastname: this.person.lastname })
      .subscribe(
        data => {
          console.log(data);
          this.person = data as Person;
        },
        error => console.log(error));
  }*/

  deletePerson() {
    this.personService.deletePerson(this.person.id)
      .subscribe(
        data => {
          console.log(data);
          this.listComponent.reloadData();
        },
        error => console.log(error));
  }

}
