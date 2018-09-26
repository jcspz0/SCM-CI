import { Component, OnInit } from '@angular/core';
import { Person } from '../model/person';
import { PersonService } from '../person.service';

@Component({
  selector: 'search-person',
  templateUrl: './search-person.component.html',
  styleUrls: ['./search-person.component.css']
})
export class SearchPersonComponent implements OnInit {

  name: string;
  persons: Person[];

  constructor(private dataService: PersonService) { }

  ngOnInit() {
    this.name = 'prueba';
  }

  private searchPersons() {
    this.dataService.getPersonByName(this.name)
      .subscribe(people => this.persons = people);
  }

  onSubmit() {
    this.searchPersons();
  }

}
