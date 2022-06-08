import '@polymer/polymer/polymer-legacy.js';
import '../../admin/products/dynamic-view-grid.js';
import '../../admin/products/dynamic-form.js';
import { html } from '@polymer/polymer/lib/utils/html-tag.js';
import { PolymerElement } from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-split-layout/src/vaadin-split-layout.js';
import '@vaadin/vaadin-checkbox/src/vaadin-checkbox.js';

class DynamicTreeDisplay extends PolymerElement {
  static get template() {
    return html`
<style include="shared-styles">
:host {
/* 	display: block; */
	flex-grow:1; 
/*	height: 1000px; */  
/*	width: 100%; */
/* 		 display: flex;  */
/*          flex-direction: column;  */
/*          height: 100%; */
	 
}
</style>
<div id="divQuery" style="flex:none"></div>
<vaadin-horizontal-layout>
 <div id="divExporter"></div>
 <div id="itemButtons">
  <vaadin-button id="newRow" theme="icon" on-click="_hideQuery">
   <iron-icon icon="lumo:plus"></iron-icon>
  </vaadin-button>
  <vaadin-button id="deleteRow" theme="icon">
   <iron-icon icon="lumo:cross"></iron-icon>
  </vaadin-button>
 </div>
</vaadin-horizontal-layout>
<div id="divTree"></div>
<div id="divDisplayAndSubgrids">
 <vaadin-split-layout orientation="vertical">
  <div>
   <form-buttons-bar id="buttons"></form-buttons-bar>
   <div id="divDisplay"></div>
  </div>
  <div id="divSubGrid" style="flex: 1 1 667px;"></div>
 </vaadin-split-layout>
</div>
<vaadin-grid-pro id="grid" column-reordering-allowed="" style="display:none"></vaadin-grid-pro>
`;
  }

  static get is() {
      return 'dynamic-tree-display';
  }
  static get properties() {
      return {
          // Declare your properties here.
      };
  }
}
customElements.define(DynamicTreeDisplay.is, DynamicTreeDisplay);

