import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-tabs/src/vaadin-tabs.js';
import '@vaadin/vaadin-tabs/src/vaadin-tab.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-area.js';

class PropuestaAltaClientesForm extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<div style="width: 100%; margin: var(--lumo-space-xs);">
 <fieldset style="display:flex">
  <legend>lo que quieras</legend>
  <vaadin-text-field label="Empresa" placeholder="Escribe el nombre" id="col0" helper-text="dsgdfgfad"></vaadin-text-field>
  <vaadin-button theme="tertiary">
    Tertiary 
  </vaadin-button>
 </fieldset>
 <vaadin-combo-box></vaadin-combo-box>
 <br>
 <vaadin-button>
   Secondary 
 </vaadin-button>
 <vaadin-button>
  <iron-icon icon="lumo:edit" slot="prefix"></iron-icon> Edit 
 </vaadin-button>
 <br>
 <vaadin-button theme="primary">
   Primary 
 </vaadin-button>
 <br>
 <vaadin-text-area label="Write a description" placeholder="Add detailed explanation"></vaadin-text-area>
 <vaadin-button theme="icon" aria-label="Add new">
  <iron-icon icon="lumo:plus"></iron-icon>
 </vaadin-button>
 <vaadin-button>
  <iron-icon icon="lumo:plus" slot="suffix"></iron-icon>Hola 
 </vaadin-button>
</div>
<vaadin-tabs>
 <vaadin-tab selected>
   Tab one 
 </vaadin-tab>
 <vaadin-tab>
   Tab two 
 </vaadin-tab>
 <vaadin-tab></vaadin-tab>
 <vaadin-tab>
   Tab three 
 </vaadin-tab>
</vaadin-tabs>
<vaadin-text-area label="Write a description" placeholder="Add detailed explanation"></vaadin-text-area>
`;
    }

    static get is() {
        return 'propuesta-alta-clientes-form';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(PropuestaAltaClientesForm.is, PropuestaAltaClientesForm);
