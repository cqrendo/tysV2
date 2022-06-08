import { PolymerElement } from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-grid/src/vaadin-grid.js';
import '../../components/search-bar.js';
import '../../components/utils-mixin.js';
import '../../../styles/shared-styles.js';
import '@vaadin/vaadin-grid-pro/src/vaadin-grid-pro.js';
import { html } from '@polymer/polymer/lib/utils/html-tag.js';
import '@vaadin/flow-frontend/file-download-wrapper.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';

class DynamicGrid extends PolymerElement {
  static get template() {
    return html`
<style include="shared-styles">
      :host {
  /*    	height: 75%; */   
        display: flex; 
        flex-direction: column; 
    	
 /* 	overflow:hidden; */
      }
    </style>
<vaadin-horizontal-layout> 
 <div id="divExporter"></div>
 <div id="itemButtons">
  <vaadin-button id="newRow" theme="icon" on-click="_hideQuery" >
   <iron-icon icon="lumo:plus"></iron-icon>
  </vaadin-button>
  <vaadin-button id="deleteRow" theme="icon">
   <iron-icon icon="lumo:cross"></iron-icon>
  </vaadin-button>
 </div>
</vaadin-horizontal-layout>
<div id="divGrid"  style="height:97%;"></div>

`;
  }

  static get is() {
    return 'dynamic-grid';
  }
  _hideQuery() {
//var elmnt = this.parentElement.parentElement.parentElement.querySelector("#divQuery");// <- How do i get this component that is in Js that contains this
//var elmnt = this.getRootNode().querySelector("#divQuery");
//var vheight = elmnt.offsetHeight;  <vaadin-grid-pro id="grid" column-reordering-allowed=""></vaadin-grid-pro>
alert(" H -> " +vheight);
var c;
c = 'calc(100% - 30px)';
elmnt.style.setProperty('display', 'none');	
this.parentElement.parentElement.parentElement.style.setProperty('height', c);
 }
 // document.getElementById('querySplitGrid').style.setProperty('height', c);

}
window.customElements.define(DynamicGrid.is, DynamicGrid);

