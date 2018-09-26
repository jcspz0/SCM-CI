import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PersonListComponent } from './person-list/person-list.component';
import { CreatePersonComponent } from './create-person/create-person.component';
import { SearchPersonComponent } from './search-person/search-person.component';

const routes: Routes = [
    { path: '', redirectTo: 'person', pathMatch: 'full' },
    { path: 'person', component: PersonListComponent },
    { path: 'add', component: CreatePersonComponent },
    { path: 'findbyname', component: SearchPersonComponent },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule { }
