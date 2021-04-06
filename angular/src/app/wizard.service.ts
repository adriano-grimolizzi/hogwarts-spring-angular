import { WIZARDS } from "./mock-wizards";
import { Wizard } from "./model/wizard";

import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs/internal/Observable";
import { of } from "rxjs/internal/observable/of";
import { Injectable } from "@angular/core";

@Injectable({ providedIn: 'root' })
export class WizardService {
  
  public wizardList: Wizard[] = WIZARDS;

  constructor(private http: HttpClient) {}

  saveWizard(wizard: Wizard) {
    wizard.id =
      this.wizardList.length !== 0
        ? Math.max.apply(
            Math,
            this.wizardList.map((elem) => elem.id)
          ) + 1
        : 1;
    this.wizardList.push(wizard);
  }

  getWizard(id: number): Observable<Wizard> {
    return of(this.wizardList.find((wizard) => wizard.id === id));
  }

  getWizards(): Observable<Wizard[]> {
    return this.http.get<Wizard[]>("http://localhost:8080/wizards");
  }

  deleteWizard(id: number) {
    this.wizardList = this.wizardList.filter((elem) => elem.id !== id);
  }
}
