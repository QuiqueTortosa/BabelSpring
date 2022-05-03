/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { FormacionService } from './formacion.service';

describe('Service: Formacion', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FormacionService]
    });
  });

  it('should ...', inject([FormacionService], (service: FormacionService) => {
    expect(service).toBeTruthy();
  }));
});
