import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-layout.js';
import '@vaadin/vaadin-checkbox/src/vaadin-checkbox.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-date-picker/src/vaadin-date-picker.js';
import '../../generic/dynamic-grid.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';

class HistogramaForm extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }          
      vaadin-text-field.veryBig{
                width: var(--vaadin-text-field-default-width, 28em);
                margin-left: 5px;
      }
      
      vaadin-text-field.big{
                width: var(--vaadin-text-field-default-width, 20em);
                margin-left: 5px;
      }
      vaadin-text-field.medium{
                width: var(--vaadin-text-field-default-width, 10em);
                margin-left: 5px;
            }
      vaadin-text-field.veryVerySmall{
                width: var(--vaadin-text-field-default-width, 2em);
                margin-left: 5px;
            }
      vaadin-text-field.veryVerySmall3{
                width: var(--vaadin-text-field-default-width, 3em);
                margin-left: 5px;
            }
      vaadin-text-field.verySmall{
            width: var(--vaadin-text-field-default-width, 4em);  
 				margin-left: 5px;
             }  
      vaadin-text-field.verySmall6{
            width: var(--vaadin-text-field-default-width, 6em);  
 				margin-left: 5px;
             }  
      vaadin-text-field.small{
                width: var(--vaadin-text-field-default-width, 8em);
                margin-left: 5px;
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
		padding-right:  0.75rem; margin-right: 0px;"
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
				.cel {
        			display:inline-block;
        			width: 100%;
					min-width:320px;
				    padding: 1em;
				    text-align: center;
				    color: lightgray;
	            }
  page {
    display: flex;
    flex-direction: column;
    align-items: center;
    width:100%;
  }
fieldset {
    color: #9a3261;
    font-size: smaller;
    border: 1px solid #9a3261;
    width:100%;
}

    </style>
<h3 id="title" style="height:0px"></h3>
<vaadin-form-layout id="form"></vaadin-form-layout>
<div class="linCampos" style="width: 900px; margin: var(--lumo-space-s);">
 <vaadin-text-field id="col0" class="big" label="Descripción"></vaadin-text-field>
 <vaadin-text-field id="col1" label="Dimensiones" class="medium"></vaadin-text-field>
 <vaadin-text-field id="col3" class="verySmall6" label="CM"></vaadin-text-field>
 <vaadin-text-field id="col2" class="verySmall6" label="CUE"></vaadin-text-field>
</div>
<div class="cel" id="cell1" style="width: 900px;">
 <div style="display:inline-block; width: 36%;">
  <vaadin-tabs selected="{{page1}}" id="tbTab1">
   <vaadin-tab>
     Alma 
   </vaadin-tab>
   <vaadin-tab>
     Global 
   </vaadin-tab>
   <vaadin-tab>
     Galicia (G) 
   </vaadin-tab>
   <vaadin-tab>
     Galicia (T) 
   </vaadin-tab>
  </vaadin-tabs>
  <iron-pages selected="[[page1]]">
   <page>
    <div style="width: 100%;max-height:150px;">
     <dynamic-grid id="grid01" style="display:none; max-height: 150px;"></dynamic-grid>
    </div>
   </page>
   <page>
    <div style="width: 100%;max-height:250px;">
     <dynamic-grid id="grid02" style="display:none; max-height: 150px;"></dynamic-grid>
    </div>
   </page>
   <page>
    <div style="width: 100%;max-height:250px;">
     <dynamic-grid id="grid03" style="display:none; max-height: 150px;"></dynamic-grid>
    </div>
   </page>
   <page>
    <div style="width: 100%;max-height:250px;">
     <dynamic-grid id="grid04" style="display:; max-height: 150px;"></dynamic-grid>
    </div>
   </page>
  </iron-pages>
 </div>
 <div style="width:30%; display:inline-block; width: 29%;">
  <dynamic-grid id="dgSituacion" style="max-height: 150px;"></dynamic-grid>
 </div>
 <div style="display:inline-block; width: 33%;">
  <vaadin-tabs selected="{{page11}}" id="tbTab11">
   <vaadin-tab>
     Alma 
   </vaadin-tab>
   <vaadin-tab>
     Global 
   </vaadin-tab>
   <vaadin-tab>
     Galicia (G) 
   </vaadin-tab>
   <vaadin-tab>
     Galicia (T) 
   </vaadin-tab>
  </vaadin-tabs>
  <iron-pages selected="[[page1]]">
   <page>
    <div style="width:100%;max-height:250px;">
     <vaadin-text-field id="col" class="verySmall6" label="Desde(AAAAMM)"></vaadin-text-field>
     <vaadin-text-field id="col" class="verySmall6" label="Hasta(AAAAMM)"></vaadin-text-field>
     <vaadin-text-field id="col" label="Meses Cálculo VeM"></vaadin-text-field>
     <vaadin-text-field id="col" class="verySmall6" label="Venta Media"></vaadin-text-field>
     <vaadin-text-field id="col" class="verySmall6" label="Total Salidas VeM"></vaadin-text-field>
     <vaadin-text-field id="col" class="verySmall6" label="TAM"></vaadin-text-field>
     <vaadin-text-field id="col" class="verySmall6" label="Pdte. Recibir"></vaadin-text-field>
    </div>
   </page>
   <page>
    <div style="width:100%;max-height:250px;">
     <vaadin-text-field id="col" class="verySmall6" label="Venta Media"></vaadin-text-field>
     <vaadin-text-field id="col" class="verySmall6" label="Stock Mínimo"></vaadin-text-field>
     <vaadin-text-field id="col" class="verySmall6" label="Cantidad a Pedir"></vaadin-text-field>
     <vaadin-text-field id="col" class="verySmall6" label="Pdte. Recibir"></vaadin-text-field>
    </div>
   </page>
   <page>
    <div style="width:100%;max-height:250px;">
     <vaadin-text-field id="col" class="verySmall6" label="Venta Media"></vaadin-text-field>
     <vaadin-text-field id="col" class="verySmall6" label="Stock Mínimo"></vaadin-text-field>
     <vaadin-text-field id="col" class="verySmall6" label="Cantidad a Pedir"></vaadin-text-field>
     <vaadin-text-field id="col" class="verySmall6" label="Pdte. Recibir"></vaadin-text-field>
    </div>
   </page>
   <page>
    <div style="width:100%;max-height:250px;">
     <vaadin-text-field id="col" class="verySmall6" label="Venta Media"></vaadin-text-field>
     <vaadin-text-field id="col" class="verySmall6" label="Stock Mínimo"></vaadin-text-field>
     <vaadin-text-field id="col" class="verySmall6" label="Cantidad a Pedir"></vaadin-text-field>
     <vaadin-text-field id="col" class="verySmall6" label="Pdte. Recibir"></vaadin-text-field>
    </div>
   </page>
  </iron-pages>
 </div>
 <dynamic-grid id="dgProvLin" style="display:; max-height: 150px;"></dynamic-grid>
 <dynamic-grid id="dgProvAlt" style="display:; max-height: 150px;"></dynamic-grid>
</div>
`;
    }

    static get is() {
        return 'histograma-form';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(HistogramaForm.is, HistogramaForm);
