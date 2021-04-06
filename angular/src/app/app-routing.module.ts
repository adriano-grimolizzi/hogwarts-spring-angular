import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {HomeScreenComponent} from './home-screen/home-screen.component';
import {WizardListComponent} from './wizard-list/wizard-list.component';
import {WizardDetailsComponent} from './wizard-details/wizard-details.component';

const appRoutes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeScreenComponent },
  { path: 'wizards/list', component: WizardListComponent },
  { path: 'wizards/detail/:id', component: WizardDetailsComponent},
  { path: 'wizards/create', component: WizardDetailsComponent },
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {
}
