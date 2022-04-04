import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-area.js';
import '@vaadin/vaadin-text-field/src/vaadin-integer-field.js';
import '@vaadin/vaadin-tabs/src/vaadin-tabs.js';
import '@vaadin/vaadin-tabs/src/vaadin-tab.js';
import '@polymer/iron-pages/iron-pages.js';
import '../../admin/products/dynamic-view-grid.js';

class ProveedoresForm extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
       vaadin-form-layout { 
       
        overflow: auto; 
       } 
      :host(.custom-style) [part="input-field"] {
        border: 10px solid #ccc;
        background-color: #bbb;
      }
       :host([focused].custom-style) [part="input-field"] {
        border-color: #aaa;
      }
	    
       vaadin-form-item { 
       
    	flex: auto ;
	    overflow: auto; 
 	    --vaadin-form-item-label-width: 1em; 
        --vaadin-form-item-label-spacing: 1em;
        --vaadin-form-item-row-spacing: 1.25em; 
 	    }  
    
          
      .veryBig{
                width: var(--vaadin-text-field-default-width, 28em);
                margin-left: 5px;
      }
      
      .big{
                width: var(--vaadin-text-field-default-width, 20em);
                margin-left: 5px;
      }
      .medium{
                width: var(--vaadin-text-field-default-width, 10em);
                margin-left: 5px;
            }
      .verySmall{
            width: var(--vaadin-text-field-default-width, 4em);  
 				margin-left: 5px;
             }  
      .verySmall2{
            width: var(--vaadin-text-field-default-width, 2em);  
 				margin-left: 5px;
             }  
      .small{
                width: var(--vaadin-text-field-default-width, 8em);
                margin-left: 15px;
            }  
      vaadin-date-picker {
      			width: var(--vaadin-text-field-default-width, 10em);
      			margin-left: 5px;
      }  
      div.linCampos {
/*       margin-top: 0px; */
      margin-left: 20px;
/*       height: 70px; */
/*       text-align:justify; */
/*       	display: flex;  */
      
/*        justify-content: left;  */
      } 
      div.lastColumn {
      float:right;
      margin-right:24px;
      }     
/*       vaadin-form-item{ */
/*       	background-color: rgba(0, 0, 0, 0.05); */
/*             }                 */
/* /*       vaadin-text-field { */ */
/* /*   	border: 10px solid gray; */ */
/*   	height:"100px""; */
  	
/* 		} */
	clean{
		padding-right:  0.75rem; margin-right: 0px;
	}
	/* Style the tab */
.tab {
  overflow: hidden;
  border: 1px solid #ccc;
  background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab button {
  background-color: inherit;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  transition: 0.3s;
  font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
  background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
  background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
  display: none;
  padding: 6px 12px;
  border: 1px solid #ccc;
  border-top: none;
}
    </style>
<div style="width: 100%; height: 100%;">
 <div></div>
 <vaadin-integer-field id="col2" class="verySmall" label="Proveedor"></vaadin-integer-field>
 <vaadin-text-field label="Nombre" id="col31" class="veryBig"></vaadin-text-field>
 <vaadin-text-field id="col0" label="DNI o CIF"></vaadin-text-field>
 <vaadin-text-field label="Tipo Prov." class="verySmall" id="col43" style="width:58px"></vaadin-text-field>
 <vaadin-text-field id="col48" class="verySmall2" label="Origen" style="margin-right:0; width:40px;"></vaadin-text-field>
 <vaadin-integer-field id="col49" label=" " style="margin-left: 0;"></vaadin-integer-field>
 <div>
  <vaadin-tabs selected="{{page}}">
   <vaadin-tab selected>
     Datos 
   </vaadin-tab>
   <vaadin-tab>
     Datos CCS 
   </vaadin-tab>
   <vaadin-tab>
     Avisos Observaciones 
   </vaadin-tab>
   <vaadin-tab>
     Eventos 
   </vaadin-tab>
  </vaadin-tabs>
  <iron-pages selected="[[page]]">
   <page>
    <h3>Page ewtert</h3>Hello World 
   </page>
   <page>
    <h3>Page 2</h3>Hi All 
   </page>
   <page>
    <h3>Page 3</h3>Good Morning 
   </page>
   <page>
    <dynamic-grid id="dvgEventos"></dynamic-grid>
   </page>
  </iron-pages>
 </div>
</div>
<vaadin-dialog id="dialogForPick"></vaadin-dialog>
`;
    }

    static get is() {
        return 'proveedores-form';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(ProveedoresForm.is, ProveedoresForm);
