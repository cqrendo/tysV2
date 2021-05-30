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
/* Style las lineas de las gráficas */
vaadin-chart {
    --vaadin-charts-color-0: blue;
    --vaadin-charts-color-1: green;
}

    </style>
<h3 id="title" style="height:0px"></h3>
<vaadin-form-layout id="form"></vaadin-form-layout>
<div class="linCampos" style="width: 100%; margin: var(--lumo-space-s);">
 <vaadin-text-field id="col0" class="big" label="Descripción"></vaadin-text-field>
 <vaadin-text-field id="col1" label="Dimensiones" class="medium"></vaadin-text-field>
 <vaadin-text-field id="col3" class="verySmall6" label="CM"></vaadin-text-field>
 <vaadin-text-field id="col2" class="verySmall6" label="CUE"></vaadin-text-field>
</div>
<div class="cel" id="cell1" style="width: 1000px;">
 <div style="display:inline-block; width: 667px;height:454px;float:left;">
  <vaadin-tabs selected="{{page1}}" id="tbTab1">
   <vaadin-tab>
     Almac. 
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
    <div id="char1"></div>
   </page>
   <page>
    <div id="char2"></div>
   </page>
   <page>
    <div id="char3"></div>
   </page>
   <page>
    <div id="char4"></div>
   </page>
  </iron-pages>
 </div>
 <div style="width:300px; display:inline-block;float:left;">
  <dynamic-grid id="dgSituacion" style="max-height: 250px;margin: 0 20px;"></dynamic-grid>
 </div>
 <div style="display:inline-block; width: 300px;float:left;min-height: 240px;">
  <span style="color: #000040;font-weight:500;font-size: 12px">Total</span>
  <vaadin-tabs selected="{{page5}}" id="tbTab2">
   <vaadin-tab>
     Almac. 
   </vaadin-tab>
   <vaadin-tab>
     Global 
   </vaadin-tab>
   <vaadin-tab>
     Gal.(G) 
   </vaadin-tab>
   <vaadin-tab>
     Gal.(T) 
   </vaadin-tab>
  </vaadin-tabs>
  <iron-pages selected="[[page5]]">
   <page>
    <div style="width:200px;">
     <vaadin-text-field id="alm3" class="verySmall6" label="Desde(AAAAMM)" readonly=""></vaadin-text-field>
     <vaadin-text-field id="alm4" class="verySmall6" label="Hasta(AAAAMM)" readonly=""></vaadin-text-field>
     <vaadin-text-field id="alm5" label="Meses Cálculo VeM" readonly=""></vaadin-text-field>
     <vaadin-text-field id="alm6" class="verySmall6" label="Venta Media" readonly=""></vaadin-text-field>
     <vaadin-text-field id="alm7" class="verySmall6" label="Total Salidas VeM" readonly=""></vaadin-text-field>
     <vaadin-text-field id="alm9" class="verySmall6" label="TAM" readonly=""></vaadin-text-field>
     <vaadin-text-field id="alm8" class="verySmall6" label="Pdte. Recibir" readonly=""></vaadin-text-field>
    </div>
   </page>
   <page>
    <div style="width:200px;">
     <vaadin-text-field id="col5" class="verySmall6" label="Venta Media"></vaadin-text-field>
     <vaadin-text-field id="col6" class="verySmall6" label="Stock Mínimo"></vaadin-text-field>
     <vaadin-text-field id="col7" class="verySmall6" label="Cantidad a Pedir"></vaadin-text-field>
     <vaadin-text-field id="col4" class="verySmall6" label="Pdte. Recibir"></vaadin-text-field>
    </div>
   </page>
   <page>
    <div style="width:200px;">
     <vaadin-text-field id="col8" class="verySmall6" label="Venta Media"></vaadin-text-field>
     <vaadin-text-field id="col9" class="verySmall6" label="Stock Mínimo"></vaadin-text-field>
     <vaadin-text-field id="col10" class="verySmall6" label="Cantidad a Pedir"></vaadin-text-field>
     <vaadin-text-field id="col11" class="verySmall6" label="Pdte. Recibir"></vaadin-text-field>
    </div>
   </page>
   <page>
    <div style="width:200px;">
     <vaadin-text-field id="col12" class="verySmall6" label="Venta Media"></vaadin-text-field>
     <vaadin-text-field id="col13" class="verySmall6" label="Stock Mínimo"></vaadin-text-field>
     <vaadin-text-field id="col14" class="verySmall6" label="Cantidad a Pedir"></vaadin-text-field>
     <vaadin-text-field id="col15" class="verySmall6" label="Pdte. Recibir"></vaadin-text-field>
    </div>
   </page>
  </iron-pages>
 </div>
</div>
<dynamic-grid id="dgProvLin" style="max-height: 150px;clear:both;"></dynamic-grid>
<dynamic-grid id="dgProvAlt" style="max-height: 150px;"></dynamic-grid>
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
