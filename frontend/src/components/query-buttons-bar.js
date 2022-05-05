import { PolymerElement } from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import './buttons-bar.js';
import { html } from '@polymer/polymer/lib/utils/html-tag.js';
{
  class QueryButtonsBarElement extends PolymerElement {
    static get template() {
      return html`
   <vaadin-horizontal-layout style="top: -7px;position: relative;"> 
    <vaadin-button theme="icon" aria-label="Buscar" id="bSearch" title="Buscar" style="padding-left: 6px;"> 
     <iron-icon icon="lumo:search"></iron-icon> 
    </vaadin-button> 
    <vaadin-button theme="icon" aria-label="Limpiar" id="bCleanSearch" title="Limpiar campos" style="padding-left: 6px;"> 
     <iron-icon icon="lumo:cross"></iron-icon> 
    </vaadin-button>  
    <!--   <iron-icon icon="lumo:plus"></iron-icon> --> 
   </vaadin-horizontal-layout> 
`;
    }

    static get is() {
      return 'query-buttons-bar';
    }
  }
  window.customElements.define(QueryButtonsBarElement.is, QueryButtonsBarElement);
}

