import {WizardFormElement} from './model/wizard-form-element';

export const FORM_ELEMENTS: WizardFormElement[] = [{
  label: 'Name',
  wizardElementName: 'name',
  placeholder: 'name',
  type: 'text',
  disabled: false,
}, {
  label: 'Surname',
  placeholder: 'surname',
  wizardElementName: 'surname',
  type: 'text',
  disabled: false,
}, {
  label: 'Consent',
  wizardElementName: 'consent',
  type: 'checkbox',
  disabled: false
}];
