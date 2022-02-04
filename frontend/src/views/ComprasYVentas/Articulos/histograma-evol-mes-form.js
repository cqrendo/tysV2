import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-layout.js';
import '@vaadin/vaadin-checkbox/src/vaadin-checkbox.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-date-picker/src/vaadin-date-picker.js';
import '../../generic/dynamic-grid.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@polymer/iron-pages/iron-pages.js';

class HistogramaEvolMesForm extends PolymerElement {

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
      vaadin-text-field.verySmall7{
            width: var(--vaadin-text-field-default-width, 7em);  
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
    --vaadin-charts-color-0: #eae047;
    --vaadin-charts-color-1: #5791ec;
}
.char {
	width: 667px;
	height:454px;
}
    </style>
<h3 id="title" style="height:0px"></h3>
<fieldset style="width: 560px; margin: var(--lumo-space-s); display:inline-block;">
 <legend>Cálculo General</legend>
 <div class="linCampos">
  <vaadin-text-field id="ev13" class="verySmall7" label="Desde (AAAAMM)"></vaadin-text-field>
  <vaadin-text-field id="ev14" label="Hasta (AAAAMM)" class="verySmall7"></vaadin-text-field>
  <vaadin-checkbox id="ckev15">
    Rango automático 
  </vaadin-checkbox>
  <vaadin-button id="btActualizar">
    ACTUALIZAR 
  </vaadin-button>
 </div>
</fieldset>
<fieldset style="width: 300px; margin: var(--lumo-space-s); display:inline-block; ">
 <legend>Cálculo x rango</legend>
 <div class="linCampos">
  <vaadin-text-field id="col34" class="verySmall7" label="Desde (AAAAMM)"></vaadin-text-field>
  <vaadin-text-field id="col35" label="Hasta (AAAAMM)" class="verySmall7"></vaadin-text-field>
 </div>
</fieldset>
<div class="cel" id="cell1" style="width: 1000px;">
 <div style="display:inline-block; width: 667px;height:454px;float:left;">
  <vaadin-tabs selected="{{page1}}" id="tbTab1">
   <vaadin-tab on-click="handleClickTab1">
     Almacén 
   </vaadin-tab>
   <vaadin-tab on-click="handleClickTab2">
     Global 
   </vaadin-tab>
   <vaadin-tab on-click="handleClickTab3">
     Galicia (G) 
   </vaadin-tab>
   <vaadin-tab on-click="handleClickTab4">
     Galicia (T) 
   </vaadin-tab>
  </vaadin-tabs>
  <iron-pages selected="[[page1]]">
   <page>
    <div class="char">
     <div id="char1"></div>
    </div>
   </page>
   <page>
    <div class="char">
     <div id="char2"></div>
    </div>
   </page>
   <page>
    <div class="char">
     <div id="char3"></div>
    </div>
   </page>
   <page>
    <div class="char">
     <div id="char4"></div>
    </div>
   </page>
  </iron-pages>
 </div>
 <div style="display:inline-block; width: 300px;float:left;">
  <div style="height:400px;">
   <vaadin-tabs selected="{{page1}}" id="tbTab2">
    <vaadin-tab on-click="handleClickTab1">
      Almac. 
    </vaadin-tab>
    <vaadin-tab on-click="handleClickTab2">
      Global 
    </vaadin-tab>
    <vaadin-tab on-click="handleClickTab3">
      Gal.(G) 
    </vaadin-tab>
    <vaadin-tab on-click="handleClickTab4">
      Gal.(T) 
    </vaadin-tab>
   </vaadin-tabs>
   <iron-pages selected="[[page1]]">
    <page>
     <fieldset>
      <legend>Almacén</legend>
      <div style="width:200px;">
       <vaadin-text-field id="alm17" class="verySmall6" label="Meses Calc VM" readonly></vaadin-text-field>
       <vaadin-text-field id="alm18" class="verySmall6" label="Venta Media" readonly></vaadin-text-field>
       <vaadin-text-field id="alm19" class="verySmall6" label="Total Sal VM" readonly></vaadin-text-field>
       <vaadin-text-field id="alm20" class="verySmall6" label="TAM" readonly></vaadin-text-field>
       <vaadin-text-field id="alm7" class="verySmall6" label="Stock Min" readonly></vaadin-text-field>
       <vaadin-text-field id="alm21" class="verySmall6" label="Cant a pedir" readonly></vaadin-text-field>
       <vaadin-text-field id="alm3" class="verySmall6" label="Pdtes Servir" readonly></vaadin-text-field>
       <vaadin-text-field id="alm10" class="verySmall6" label="Pdtes recibir" readonly></vaadin-text-field>
       <vaadin-text-field id="alm40" class="verySmall6" label="Cant Colec" readonly></vaadin-text-field>
       <vaadin-text-field id="alm41" class="verySmall6" label="Ped x Colec" readonly></vaadin-text-field>
       <vaadin-text-field id="alm42" class="verySmall6" label="Stock x Clase" readonly></vaadin-text-field>
      </div>
     </fieldset>
     <fieldset>
      <legend>Cálculo x Rango</legend>
      <div style="width:200px;">
       <vaadin-text-field id="alm37" class="verySmall6" label="Venta Media" readonly></vaadin-text-field>
       <vaadin-text-field id="alm38" class="verySmall6" label="Total Salidas" readonly></vaadin-text-field>
      </div>
     </fieldset>
    </page>
    <page>
     <fieldset>
      <legend>Global</legend>
      <div style="width:200px;">
       <vaadin-text-field id="col11" class="verySmall6" label="Venta Media" readonly></vaadin-text-field>
       <vaadin-text-field id="col12" class="verySmall6" label="Stock Min" readonly></vaadin-text-field>
       <vaadin-text-field id="col13" class="verySmall6" label="Cant a pedir" readonly></vaadin-text-field>
       <vaadin-text-field id="col14" class="verySmall6" label="TAM" readonly></vaadin-text-field>
       <vaadin-text-field id="col3" class="verySmall6" label="Pdtes Servir" readonly></vaadin-text-field>
       <vaadin-text-field id="col2" class="verySmall6" label="Pdtes Recibir" readonly></vaadin-text-field>
       <vaadin-text-field id="col5" class="verySmall6" label="Stock" readonly></vaadin-text-field>
      </div>
     </fieldset>
     <fieldset>
      <legend>Cálculo x Rango</legend>
      <div style="width:200px;">
       <vaadin-text-field id="col15" class="verySmall6" label="Venta Media" readonly></vaadin-text-field>
      </div>
     </fieldset>
    </page>
    <page>
     <fieldset>
      <legend>Galicia (G)</legend>
      <div style="width:200px;">
       <vaadin-text-field id="col20" class="verySmall6" label="Venta Media" readonly></vaadin-text-field>
       <vaadin-text-field id="col21" class="verySmall6" label="Stock Min" readonly></vaadin-text-field>
       <vaadin-text-field id="col22" class="verySmall6" label="Cant a pedir" readonly></vaadin-text-field>
       <vaadin-text-field id="col23" class="verySmall6" label="TAM" readonly></vaadin-text-field>
       <vaadin-text-field id="col50" class="verySmall6" label="Pdtes Servir" readonly></vaadin-text-field>
       <vaadin-text-field id="col49" class="verySmall6" label="Pdtes Recibir" readonly></vaadin-text-field>
       <vaadin-text-field id="col48" class="verySmall6" label="Stock" readonly></vaadin-text-field>
      </div>
     </fieldset>
     <fieldset>
      <legend>Cálculo x Rango</legend>
      <div style="width:200px;">
       <vaadin-text-field id="col27" class="verySmall6" label="Venta Media" readonly></vaadin-text-field>
      </div>
     </fieldset>
    </page>
    <page>
     <fieldset>
      <legend>Galicia (T)</legend>
      <div style="width:200px;">
       <vaadin-text-field id="col29" class="verySmall6" label="Venta Media" readonly></vaadin-text-field>
       <vaadin-text-field id="col30" class="verySmall6" label="Stock Min" readonly></vaadin-text-field>
       <vaadin-text-field id="col31" class="verySmall6" label="Cant a pedir" readonly></vaadin-text-field>
       <vaadin-text-field id="col32" class="verySmall6" label="TAM" readonly></vaadin-text-field>
       <vaadin-text-field id="col39" class="verySmall6" label="Pdtes Servir" readonly></vaadin-text-field>
       <vaadin-text-field id="col38" class="verySmall6" label="Pdtes Recibir" readonly></vaadin-text-field>
       <vaadin-text-field id="col37" class="verySmall6" label="Stock" readonly></vaadin-text-field>
      </div>
     </fieldset>
     <fieldset>
      <legend>Cálculo x Rango</legend>
      <div style="width:200px;">
       <vaadin-text-field id="col36" class="verySmall6" label="Venta Media" readonly></vaadin-text-field>
      </div>
     </fieldset>
    </page>
   </iron-pages>
  </div>
 </div>
</div>
`;
    }

    static get is() {
        return 'histograma-evol-mes-form';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(HistogramaEvolMesForm.is, HistogramaEvolMesForm);
