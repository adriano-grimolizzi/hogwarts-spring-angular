import { Component, OnInit } from '@angular/core';

import {Wizard} from '../model/wizard';
import {WizardService} from '../wizard.service';

@Component({
  selector: 'app-wizard-list',
  templateUrl: './wizard-list.component.html',
  styleUrls: ['./wizard-list.component.css']
})
export class WizardListComponent implements OnInit {

  public wizards: Wizard[];

  constructor(private wizardService: WizardService) { }

  ngOnInit() {
    this.wizardService.getWizards().subscribe(wizards => this.wizards = wizards);
  }
}
