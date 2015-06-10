// Copyright 2015 Google Inc. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.google.devtools.build.lib.query2.output;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.devtools.build.lib.packages.Attribute;
import com.google.devtools.build.lib.packages.Package;
import com.google.devtools.build.lib.packages.Target;
import com.google.devtools.build.lib.syntax.Label;

import java.util.Set;

/**
 * An aspect resolver that does not return any aspect dependencies.
 *
 * <p>Simple, fast, wrong.
 */
public class NullAspectResolver implements AspectResolver {
  @Override
  public ImmutableMultimap<Attribute, Label> computeAspectDependencies(Target target)
      throws InterruptedException {
    return ImmutableMultimap.of();
  }

  @Override
  public Set<Label> computeBuildFileDependencies(
      Package pkg, BuildFileDependencyMode mode) throws InterruptedException {
    return ImmutableSet.copyOf(mode.getDependencies(pkg));
  }
}
