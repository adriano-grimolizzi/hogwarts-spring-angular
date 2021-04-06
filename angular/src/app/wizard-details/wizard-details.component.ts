import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

import {Wizard} from '../model/wizard';
import {WizardService} from '../wizard.service';
import {FORM_ELEMENTS} from '../wizard-form-elements';

@Component({
  selector: 'app-wizard-details',
  templateUrl: './wizard-details.component.html',
  styleUrls: ['./wizard-details.component.css']
})
export class WizardDetailsComponent implements OnInit {

  public wizard: Wizard;

  public isEditEnabled: boolean;

  public formElementList = FORM_ELEMENTS;

  public isInCreateMode = false;

  public isInDisplayEditMode = false;

  get displayOrEditButtonText() {
    if (this.isEditEnabled) {
      return 'Done!';
    } else {
      return 'Edit Wizard';
    }
  }

  get title() {
    if (this.isInCreateMode) {
      return 'Create a Wizard:';
    } else {
      return 'Wizard\'s details';
    }
  }

  constructor(
      private wizardService: WizardService,
      private route: ActivatedRoute,
      private router: Router) { }

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id'); // Check app-routing.module.ts
    if (id) { // DISPLAY/EDIT mode
      this.wizardService.getWizard(id).subscribe(wizard => this.wizard = wizard);
      this.isEditEnabled = false;
      this.isInDisplayEditMode = true;
    } else { // CREATE mode
      this.wizard = new Wizard();
      this.isEditEnabled = true;
      this.isInCreateMode = true;
    }
  }

  onDisplayEdit() {
    this.isEditEnabled = !this.isEditEnabled;
  }

  onSave() {
    this.wizardService.saveWizard(this.wizard);
    this.router.navigateByUrl('/wizards/detail/' + this.wizard.id);
  }

  onDelete() {
    this.wizardService.deleteWizard(this.wizard.id);
    this.router.navigateByUrl('/wizards/list');
  }
}
