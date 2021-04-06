import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { WizardListComponent } from './wizard-list/wizard-list.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeScreenComponent } from './home-screen/home-screen.component';
import { WizardService } from './wizard.service';
import { WizardDetailsComponent } from './wizard-details/wizard-details.component';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  declarations: [
    AppComponent,
    WizardListComponent,
    HeaderComponent,
    HomeScreenComponent,
    WizardDetailsComponent
  ],
  providers: [
    WizardService
  ],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
